package com.api.automation.userManagementTest;

import com.api.automation.payload.requestPayload.authenticationReq.LoginRequest;
import com.api.automation.payload.responsePayload.authenticationRes.LoginResponse;
import com.api.automation.payload.responsePayload.userManagementRes.GetProfileResponse;
import com.api.automation.service.AuthService;
import com.api.automation.service.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileTest {
    @Test(description="Verify that the GET Profile API is working or not..")
    public void loginAPIStatusCodeTest() {
        //LoginRequest loginRequest = new LoginRequest("shyam78","Shyam@123");
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("shyam78","Shyam@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String generatedToken = loginResponse.getToken();
        System.out.println(generatedToken);
        UserService userService = new UserService();
        Response response1 = userService.getProfile(generatedToken);
        GetProfileResponse getProfileResponse = response1.as(GetProfileResponse.class);
        System.out.println(getProfileResponse);
    }
}
