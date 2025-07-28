package com.api.automation.authenticationTest;

import com.api.automation.payload.requestPayload.authenticationReq.LoginRequest;

import com.api.automation.payload.responsePayload.authenticationRes.LoginResponse;
import com.api.automation.service.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest {
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
    @Test(description="Verify the status code of the LogIn API Post request.",dependsOnMethods = "loginTest")
    public void loginAPIStatusCodeTest() {
        LoginRequest loginRequest = new LoginRequest("string","string");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        //System.out.println(response.asPrettyString());
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}