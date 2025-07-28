package com.api.automation.service;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService {
    private static final String base_path = "/api/auth";
    public Response login(Object payload) {
        return postRequest(payload,base_path+"/login");
    }
    public Response signUp(Object payload) {
        return postRequest(payload,base_path+"/signup");
    }
    public Response forgotPassword(String emailAddr) {
        Map<String,String> payload = new HashMap<>();
        payload.put("email",emailAddr);
        return postRequest(payload,base_path+"/forgotPassword");
    }
}