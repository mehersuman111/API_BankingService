package com.api.automation.userManagementTest;

import com.api.automation.payload.requestPayload.authenticationReq.LoginRequest;
import com.api.automation.payload.requestPayload.userManagementReq.UpdateProfileReq;
import com.api.automation.payload.responsePayload.authenticationRes.LoginResponse;
import com.api.automation.payload.responsePayload.userManagementRes.GetProfileResponse;
import com.api.automation.service.AuthService;
import com.api.automation.service.UserService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateProfileTest {
    @Test(description="Verify that the Update Profile API is working or not...")
    public void loginAPIStatusCodeTest() {
        //LoginRequest loginRequest = new LoginRequest("shyam78","Shyam@123");
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("shyam78","Shyam@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String generatedToken = loginResponse.getToken();
        System.out.println(generatedToken);

        UpdateProfileReq updateProfileReq = new UpdateProfileReq.Builder()
                .firstName("Mukesh").lastName("Kumar").email("mukesh.kumar@yahoo.com")
                .mobileNumber("8339938883").build();
        UserService userService = new UserService();
        Response response1 = userService.updateProfile(generatedToken, updateProfileReq);
        // Need to complete this testcase
        //GetProfileResponse updateProfileResponse =
        //System.out.println(updateProfileResponse);
    }
}
