package com.axxes.tim.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(tags={"~@ignore"}, format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCucumberTest {

}
