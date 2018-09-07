package io.blocko.ethboard.cucumber.stepdefs;

import io.blocko.ethboard.EthboardApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = EthboardApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
