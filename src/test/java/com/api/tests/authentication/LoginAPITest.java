package com.api.tests.authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description="Verify if Login API is working or Not.")
    public void loginTest() {
        // Breakdown of response w.r.t the return type.
        RestAssured.baseURI="http://64.227.160.186:8080";
        RequestSpecification requestSpecification = RestAssured.given();
        RequestSpecification requestSpecification1 = requestSpecification.header("Content-Type","application/json");
        RequestSpecification requestSpecification2 = requestSpecification1.body("{\n" +
                                                                    "  \"username\": \"string\",\n" +
                                                                    "  \"password\": \"string\"\n" +
                                                                    "}");
        Response response = requestSpecification2.post("/api/auth/login");
        System.out.println(response.asPrettyString());
    }

}