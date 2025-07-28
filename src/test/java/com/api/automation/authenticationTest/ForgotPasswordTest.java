package com.api.automation.authenticationTest;

import com.api.automation.payload.requestPayload.authenticationReq.LoginRequest;
import com.api.automation.payload.requestPayload.authenticationReq.SignUpRequest;
import com.api.automation.service.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description="Verify if Forgot Password API is working or Not.")
    public void ForgotPasswordTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("wajohec776@kloudis.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
