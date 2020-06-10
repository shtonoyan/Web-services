package com.epam.tests;

import com.epam.post.Post;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

    @Test
    public void checkStatusCode() {
        RestTemplate restTemplate = new RestTemplate();;
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        int actualStausCode = responseEntity.getStatusCode().value();
        Assert.assertEquals(actualStausCode, 200);
    }

    @Test
    public void checkResponseHeader() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        HttpHeaders headers = responseEntity.getHeaders();
        String contentTypeValue = headers.getContentType().toString();
        Assert.assertEquals(contentTypeValue, "application/json;charset=utf-8");
    }

    @Test
    public void checkResponseBodt() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        Post[] posts = responseEntity.getBody();
        Assert.assertEquals(posts.length, 100);


    }
}
