package com.api.tests.authentication;

import static io.restassured.RestAssured.*;

//import io.restassured.RestAssured;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestWS {

    @Test(description="Verify if Login API is working or Not.")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("string","string");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        //System.out.println(response.asPrettyString());
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse);
        System.out.println(loginResponse.getId());
        Assert.assertTrue(loginResponse.getId()!=0);
    }

}