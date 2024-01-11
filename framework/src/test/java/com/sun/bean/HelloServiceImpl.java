package com.sun.bean;

public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String message) {
        return message;
    }
}
