package com.freemarker.demo.test;

import com.freemarker.demo.apacheFreemarker.FreemarkerUtil;
import com.freemarker.demo.apacheFreemarker.ScriptList;
import com.freemarker.demo.dataTable.Skill;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FreemarkerJsonTest {
    private final FreemarkerUtil freemarkerUtil = new FreemarkerUtil();
    private final ScriptList scriptList = new ScriptList();

    @Test
    public void testGenerateJsonFile() throws IOException, TemplateException {

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("id", 101);
        dataModel.put("name", "John Doe");
        dataModel.put("email", "johndoe@mail.com");
        dataModel.put("role", "Developer");
        dataModel.put("salary", 85000);
        dataModel.put("department", "Engineering");
        dataModel.put("isActive", true);
        dataModel.put("joiningDate", "2025-01-26");
        dataModel.put("salaryLevel", "High-Level");
        dataModel.put("skills", Stream.of("Java,Kotlin,Spring,SQL".split(",")).map(Skill::new).collect(Collectors.toList()));

        String generatedJson = freemarkerUtil.processTemplate(scriptList.getEmployeeOutputScriptJson(), dataModel);

        assertTrue(generatedJson.contains("\"id\": 101"),"ID should be 101");
        assertTrue(generatedJson.contains("\"name\": John Doe"),"Name should be John Doe");
        assertTrue(generatedJson.contains("\"email\": \"johndoe@mail.com\""),"Email should be johndoe@mail.com");
        assertTrue(generatedJson.contains("\"role\": \"Developer\""),"Role should be Developer");
        assertTrue(generatedJson.contains("\"salary\": \"85,000\""),"Salary should be 85000");
        assertTrue(generatedJson.contains("\"department\": \"Engineering\""),"Department should be Engineering");
        assertTrue(generatedJson.contains("\"isActive\": true"),"isActive should be true");
        assertTrue(generatedJson.contains("\"joiningDate\": \"Jan 26, 2025"),"Joining date should be Jan 26, 2025");
        assertTrue(generatedJson.contains("\"salaryLevel\": \"High-Level\""),"Salary level should be High-Level");
        assertTrue(generatedJson.replaceAll("\\s+", "").contains("\"skills\":[\"JAVA\",\"KOTLIN\",\"SPRING\",\"SQL\"]"),"Validate skills list");
    }
}
