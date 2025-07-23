package com.api.tests.authentication;

import static io.restassured.RestAssured.*;

//import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginAPITesting {

    @Test(description="Verify if Login API is working or Not.")
    public void loginTest() {
        // Breakdown of response w.r.t the return type.
        //RestAssured.baseURI="http://64.227.160.186:8080";
        //baseURI="http://64.227.160.186:8080";
        Response response = given()
                                .baseUri("http://64.227.160.186:8080")
                                .header("Content-Type","application/json")
                            .body("{\n" +
                                    "  \"username\": \"string\",\n" +
                                    "  \"password\": \"string\"\n" +
                                    "}").post("/api/auth/login");
        System.out.println(response.asPrettyString());
    }

}