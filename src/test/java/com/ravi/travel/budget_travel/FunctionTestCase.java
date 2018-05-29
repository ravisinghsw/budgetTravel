package com.ravi.travel.budget_travel;

import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class FunctionTestCase {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private Integer port;

    @PostConstruct
    public void setUP(){
        RestAssured.baseURI="http://"+host+":"+port;
    }

}
