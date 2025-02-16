package com.freemarker.demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@Run",
        glue = {"com.freemarker.demo"},
        stepNotifications = true
)
public class CucumberRunner {
}
