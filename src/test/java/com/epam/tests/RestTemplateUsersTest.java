package com.epam.tests;

import com.epam.user.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTemplateUsersTest {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void verifyStatusCode() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", String.class);
        int actualStatusCode = responseEntity.getStatusCodeValue();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void verifyResponseHeader() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", String.class);
        HttpHeaders headers = responseEntity.getHeaders();

        String actualHeader = headers.getContentType().toString();
        Assert.assertEquals(actualHeader, "application/json;charset=utf-8");
    }

    @Test
    public void verifyPesponseBody() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        User[] users = responseEntity.getBody();
        Assert.assertEquals(users.length, 10);
    }

}
