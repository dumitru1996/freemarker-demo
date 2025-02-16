package com.freemarker.demo.apacheFreemarker;

import com.freemarker.demo.exceptions.DemoException;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class FreemarkerUtil {

    private static final Logger logger = LogManager.getLogger(FreemarkerUtil.class);
    private static final String TEMPLATE_DIRECTORY = "src/test/java/com/freemarker/demo/apacheFreemarker/scripts";

    private final static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_32);
        ClassTemplateLoader loader = new ClassTemplateLoader(FreemarkerUtil.class, TEMPLATE_DIRECTORY);
        configuration.setTemplateLoader(loader);
        try {
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_DIRECTORY));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public String processTemplate(String templateName, Object data) {
        StringWriter writer = new StringWriter();
        String populatedTemplate;
        try {
            Template freeMarkerTemplate = getTemplate(templateName);
            if (freeMarkerTemplate == null) {
                throw new DemoException(String.format("Template %s not found", templateName));
            }
            freeMarkerTemplate.process(data, writer);

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        populatedTemplate = writer.toString();

        logger.info("Template successfully populated:\n{}", populatedTemplate);
        return populatedTemplate;
    }

    private static Template getTemplate(String templateName) throws IOException {
        return configuration.getTemplate(templateName);
    }
}
