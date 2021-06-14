package com.api.dummy.testCases;

import com.api.dummy.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_Get_Single_Employee extends TestBase {
    @BeforeClass
    void getSingleEmployees() throws InterruptedException {
        logger.info("*************Started TC001_Get_All_Employees *********");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        requestSpecification = RestAssured.given();
        int empId =6390;
        response = requestSpecification.request(Method.GET,"/employees"+ empId);

        Thread.sleep(3);
    }

    @Test
    void checkResponseBody(){
        logger.info("*************Checking response Body*********");
        String responseBody = response.getBody().asString();
        logger.info("Response Body =>" +responseBody);
        Assert.assertTrue(responseBody!=null);
    }

    @Test
    void checkStatusCode(){
        logger.info("*************Checking Status Code*********");
        int statusCode = response.getStatusCode();
        logger.info("Status Code =>" +statusCode);
        Assert.assertTrue(statusCode >200);
    }

    @Test
    void checkResponseTime(){
        logger.info("*************Checking Response Time*********");
        long responseTime = response.getTime();
        logger.info("Response Time =>" +responseTime);
        Assert.assertTrue(responseTime < 3000);
    }
}
