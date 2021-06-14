package com.api.dummy.testCases;

import com.api.dummy.base.TestBase;
import com.api.dummy.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TC002_Create_Employee extends TestBase {

    String empName = RestUtils.empName();
    String empSal = RestUtils.empSal();
    String empAge = RestUtils.empAge();

    @BeforeClass
    void createEmployee() {
        logger.info("*************Started TC002_Create_Employee *********");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        requestSpecification = RestAssured.given();
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", empName);
        params.put("salary", empSal);
        params.put("age", empAge);

        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(params);
        response = requestSpecification.request(Method.POST, "/create");
    }

    @Test
    void checkResponseBody() {
        logger.info("*************Checking response Body*********");
        String responseBody = response.getBody().asString();
        logger.info("Response Body =>" + responseBody);
        Assert.assertTrue(responseBody != null);
    }

    @Test
    void checkStatusCode() {
        logger.info("*************Checking Status Code*********");
        int statusCode = response.getStatusCode();
        logger.info("Status Code =>" + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime() {
        logger.info("*************Checking Response Time*********");
        long responseTime = response.getTime();
        logger.info("Response Time =>" + responseTime);
        Assert.assertTrue(responseTime < 3000);
    }

    @Test
    void checkResponse() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(empName));
        Assert.assertTrue(responseBody.contains(empSal));
        Assert.assertTrue(responseBody.contains(empAge));
    }

}
