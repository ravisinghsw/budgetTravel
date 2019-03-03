package com.ravi.travel.budget_travel.resources;

import com.ravi.travel.budget_travel.FunctionTestCase;
import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.utilities.ApiRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.persistence.Table;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ArticleResourceTest extends FunctionTestCase {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test
    public void testGetAllArticles() {
        ValidatableResponseOptions resp = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("api/articles")
                .then();
        resp.statusCode(HttpStatus.OK.value());
        Article[] articleList =  resp.extract().body().as( Article[].class);
        log.info("Response recivied from api {}" + Arrays.deepToString(articleList));
        Assert.isTrue(articleList.length>0 ,"No List is fetched");
    }

    @Test
    public void testSingleArticle() {
        ValidatableResponseOptions resp = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("api/articles/rahul")
                .then();
        resp.statusCode(HttpStatus.OK.value());
        Article[] articleList =  resp.extract().body().as( Article[].class);
        log.info("Response recivied from api {}" + Arrays.deepToString(articleList));
        Assert.isTrue(articleList.length>0 ,"No List is fetched");
    }


    @Test
    public void testSaveArticle() throws InterruptedException {
        Article article = new Article();
       /* article.setAuthor("jai");
        article.setDescription("Delhi Darshan");
        article.setViewCount(0L);*/
        ValidatableResponseOptions resp = RestAssured.given()
                .body(article)
                .contentType(ContentType.JSON)
                .when()
                .post("api/articles")
                .then();

        resp.statusCode(HttpStatus.OK.value());
    }


}