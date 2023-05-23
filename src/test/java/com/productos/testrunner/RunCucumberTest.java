package com.productos.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/productos/features",
        glue = "com.productos.steps",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        publish = true
)
public class RunCucumberTest {
    // Puedes dejar esta clase vacía
}