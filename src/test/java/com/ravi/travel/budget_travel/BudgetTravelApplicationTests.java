package com.ravi.travel.budget_travel;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class BudgetTravelApplicationTests {

	@Test
	public void contextLoads() {
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"http://localhost:8090/articlesList");
		Assert.isTrue(( HttpStatus.OK.value() ==response.statusCode() ), "Success response received"	);
		String res = response.body().asString();
		System.out.println("RESPONSE ::"+res);

	}

	@Test
	public void testgetArticles(){

		RequestSpecification httpRequest = RestAssured.given().when();
		httpRequest.body("\"author\":\"laxmi\"");
		Response response = httpRequest.when().get("http://localhost:8090/articles");
		String res = response.body().asString();
		response.then().body("errorCode", CoreMatchers.not("500"));
		System.out.println("articles res ::"+res);
		Assert.isTrue(( HttpStatus.OK.value() ==response.statusCode() ), "Success response received"	);

	}

}
