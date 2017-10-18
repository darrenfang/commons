package com.darrenfang.commons;

public class MockObject {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public MockObject() {
        code = 200;
        message = "";
    }

    public MockObject(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
