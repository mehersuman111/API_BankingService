package com.api.automation.service;

import com.api.automation.payload.requestPayload.userManagementReq.UpdateProfileReq;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserService extends BaseService{
    private static final String base_path = "/api/users";
    public Response getProfile(String token) {
        setAuthToken(token);
        return getRequest(base_path+"/profile");
    }
    public Response updateProfile(String token, UpdateProfileReq payload) {
        setAuthToken(token);
        return putRequest(payload,"/profile");
    }
}