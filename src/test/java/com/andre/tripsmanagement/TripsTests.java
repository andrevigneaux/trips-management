package com.andre.tripsmanagement;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(OctaneCucumber.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberOptions(plugin = {"junit:junitResult.xml"}, features = "src/test/resources/features")
public class TripsTests extends UnitTestClassBase {
    public TripsTests() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new TripsTests();
        globalSetup(TripsTests.class);
        SpringApplication.run(TripsManagementApplication.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Test
    public void test() throws GeneralLeanFtException {
    }
}
