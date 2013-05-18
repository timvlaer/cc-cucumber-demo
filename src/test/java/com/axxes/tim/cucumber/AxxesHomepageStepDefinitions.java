package com.axxes.tim.cucumber;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.IOUtils;

import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AxxesHomepageStepDefinitions {

    private String result;

    @When("^ik surf naar de axxes startpagina op '(.+)'$")
    public void ik_zoek_naar(String url) throws Throwable {
        result = IOUtils.toString(new URL(url).openStream());
    }

    @Then("^moet de pagina de tekst '(.+)' bevatten$")
    public void de_resultatenlijst_moet_een_link_bevatten(final String expectedText) throws Throwable {
        assertThat("Het resultaat moet de tekst " + expectedText + " bevatten.", result, containsString(expectedText));
    }
}
