package com.epam.post;

import java.util.HashMap;
import java.util.Map;

public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private Map<String, Object> additionalPromerties = new HashMap<String, Object>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getAdditionalPromerties() {
        return additionalPromerties;
    }

    public void setAdditionalPromerties(Map<String, Object> additionalPromerties) {
        this.additionalPromerties = additionalPromerties;
    }
}
