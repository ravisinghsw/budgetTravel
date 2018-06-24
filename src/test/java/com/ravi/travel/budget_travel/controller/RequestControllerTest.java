package com.ravi.travel.budget_travel.controller;

import com.ravi.travel.budget_travel.FunctionTestCase;
import com.ravi.travel.budget_travel.utilities.ApiRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RequestControllerTest extends FunctionTestCase {



    @Ignore
    @Test
    public void getArticles() {

        ApiRequest request = new ApiRequest();
        request.setType("AUTHOR");

        Map<String,String> params = new HashMap<>();
        params.put("name","ravi");
        params.put("REQUEST_TYPE","SYNC");

        request.setParams(params);


        ValidatableResponseOptions resp = RestAssured.given()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post("api/articles")
                .then();

        resp.statusCode(HttpStatus.OK.value());

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) resp.extract().body();
        System.out.println("Response recivied from api {}" +response.asString());
    }

//@Ignore
    @Test
    public void getArticlesAsync() {

        ApiRequest request = new ApiRequest();
        request.setType("AUTHOR");

        Map<String,String> params = new HashMap<>();
        params.put("name","rahul");
        params.put("REQUEST_TYPE","ASYNC");


        request.setParams(params);


        ValidatableResponseOptions resp = RestAssured.given()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post("api/articles")
                .then();

        resp.statusCode(HttpStatus.OK.value());

        ExtractableResponse response = (ExtractableResponse) resp.extract().body();
        System.out.println("Response recivied from api {}" +response.body());
    }
}