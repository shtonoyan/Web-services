package com.epam.tests;

import com.epam.user.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RestAssuredUsersTest {
    private Response response;

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        response = RestAssured
                .when()
                .get("/users")
                .andReturn();

    }
    @Test
    public void verifyStatusCode(){
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void verifyResponseHeader(){
        assertEquals(response.getHeader("Content-type"),"application/json; charset=utf-8" );
    }

    @Test
    public void verifyResonseBody(){
        ResponseBody responseBody =  response.getBody();
        assertEquals(responseBody.as(User[].class).length, 10);
    }
}
