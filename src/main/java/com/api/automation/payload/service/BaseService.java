package com.api.automation.payload.service;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

    /* This BaseService class is responsible for handling
            1. BaseURL
            2. Creating the request
            3. Handling the response

        In simple term this is the wrapper for rest assured
     */
public class BaseService {

        private static final String baseURL = "http://64.227.160.186:8080";
        private RequestSpecification requestSpecification;

        //Construction which will initialize the instance variable i.e., requestSpecification as below
        public BaseService() {
            requestSpecification = RestAssured.given().baseUri(baseURL);
        }
        protected Response postRequest(Object payload, String endpoint) {
            return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);    // We have not provided the content type as param
                                                                                                // as we have in-build method as content type which we can provide directly.

        }

}