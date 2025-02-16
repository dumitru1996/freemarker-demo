package com.freemarker.demo.stepDef;

import com.freemarker.demo.apacheFreemarker.FileTypeEnum;
import com.freemarker.demo.apacheFreemarker.FreemarkerUtil;
import com.freemarker.demo.apacheFreemarker.ScriptList;
import com.freemarker.demo.dataTable.RequestOfUser;
import com.freemarker.demo.exceptions.DemoException;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepDefinitions {
    private static final Logger logger = LogManager.getLogger(StepDefinitions.class);

    private final FreemarkerUtil freemarkerUtil = new FreemarkerUtil();
    private final ScriptList scriptList = new ScriptList();

    @Given("^there is generated a file in (.*) format$")
    public void generateFileSpecificFileWithDetails(FileTypeEnum fileType, RequestOfUser user) {
        logger.info("Starting generation of file using freemarker!");
        switch (fileType) {
            case XML:
                freemarkerUtil.processTemplate(scriptList.getXmlScript(), user);
                break;
            case JSON:
                freemarkerUtil.processTemplate(scriptList.getEmployeeOutputScriptJson(), user);
                break;
            case SQL:
                freemarkerUtil.processTemplate(scriptList.getSqlQueryScript(), user);
                break;
            default:
                throw new DemoException(String.format("There is no %s file type!", fileType));
        }
        logger.info("Generation Completed successfully!");
    }
}
