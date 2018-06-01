package com.malsolo.springframework.cloud.contract.frauddetection;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FraudDetectionApplication.class)
public class BaseClass {

    @Autowired
    FraudController fraudController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(fraudController);
    }
}
