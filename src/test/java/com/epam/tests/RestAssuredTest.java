package com.epam.tests;

import com.epam.post.Post;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RestAssuredTest {
    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.when()
                .get("/posts")
                .andReturn();
        System.out.println(response.getStatusLine());
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeader() {
        Response response = RestAssured.when()
                .get("/post")
                .andReturn();
        String responseContentTypeHeader = response.getHeader("Content-Type");
        assertEquals(responseContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBody() {
        Response response = RestAssured.when()
                .get("/posts")
                .andReturn();

        ResponseBody responseBody = response.getBody();
        responseBody.as(Post[].class);
    }

}
