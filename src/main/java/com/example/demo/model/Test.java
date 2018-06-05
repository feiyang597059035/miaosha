package com.example.demo.model;

public class Test {
    private Integer id;

    private String test;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test == null ? null : test.trim();
    }
}