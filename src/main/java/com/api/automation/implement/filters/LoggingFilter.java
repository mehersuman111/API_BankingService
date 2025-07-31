package com.api.automation.implement.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec,responseSpec);
        logResponse(response);
        return response;
    }
    public void logRequest(FilterableRequestSpecification requestSpecification) {
        logger.info("Base URI: " + requestSpecification.getBaseUri());
        logger.info("Request Header: " + requestSpecification.getHeaders());
        logger.info("Request Body: " + requestSpecification.getBody());
    }
    public void logResponse(Response response) {
        logger.info("Response Status code: " + response.getStatusCode());
        logger.info("Response Body: " + response.getBody().prettyPrint());
        logger.info("Response Header: " + response.getHeaders());
    }
}