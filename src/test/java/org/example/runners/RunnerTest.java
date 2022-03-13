package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
@RunWith(Cucumber.class)
@CucumberOptions (plugin = {"pretty"
        , "html:target/cucumber"
        , "summary"}
        ,snippets = CAMELCASE
        ,features = {"src/test/resources"}
        ,glue = {"org.example.stepdef"}
        ,dryRun=false
        ,monochrome=true)
public class RunnerTest {


}
