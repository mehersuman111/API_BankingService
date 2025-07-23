package com.api.base;

import io.restassured.response.Response;

public class AuthService extends BaseService{

    private static final String base_path = "/api/auth";

    public Response login(Object payload) {
            return postRequest(payload,base_path+"/login");
    }
}