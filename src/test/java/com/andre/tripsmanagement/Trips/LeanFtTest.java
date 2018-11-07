package com.andre.tripsmanagement.Trips;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

import com.hp.lft.sdk.*;
import com.hpe.alm.octane.OctaneCucumber;

import com.andre.tripsmanagement.unittesting.UnitTestClassBase;
import org.springframework.boot.test.context.SpringBootTest;;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(OctaneCucumber.class)
@CucumberOptions(plugin = {"com.hp.lft.report.CucumberReporter"},
                 features = "src/test/java/com/andre/tripsmanagement/Trips")
public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Test
    public void test() throws GeneralLeanFtException {
    }
}