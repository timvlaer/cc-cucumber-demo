package com.axxes.tim.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.io.ClasspathResourceLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompetencePageStepDefinitions {

    public static final String SKILLS_PAGE = "http://www.axxes-it.com/nl/skills";

    private static ChromeDriverService service;

    private WebDriver driver;

    @Before
    public void createAndStartService() throws IOException {
        if (service == null) {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("chromedriver"))
                    .usingAnyFreePort()
                    .build();
            service.start();

            driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        }
    }

    @After
    public static void stopService() {
        service.stop();
    }


    @When("^ik surf naar de compententies pagina$")
    public void ik_surf_naar_de_compententies_pagina() throws Throwable {
        driver.get(SKILLS_PAGE);
    }

    @Then("^moet op die pagina '(.+)' staan$")
    public void moet_op_die_pagina_een_compententie_staan(String skill) throws Throwable {
        assertThat(driver.getPageSource(), containsString(skill));
    }
}
