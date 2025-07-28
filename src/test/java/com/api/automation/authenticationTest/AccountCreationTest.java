package com.api.automation.authenticationTest;

import com.api.automation.payload.requestPayload.authenticationReq.LoginRequest;
import com.api.automation.payload.requestPayload.authenticationReq.SignUpRequest;
import com.api.automation.payload.responsePayload.authenticationRes.LoginResponse;
import com.api.automation.service.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test(description="Verify if SignUp API is working or Not.")
    public void SignUpTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder().firstName("Shyam").lastName("Kumar")
                .userName("shyam78").email("wajohec776@kloudis.com")
                .mobileNumber("8399939939").password("Shyam@123")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),400);

    }
}
