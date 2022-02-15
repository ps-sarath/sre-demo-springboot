package com.example.philips.samples.sredemo.todo;

public class TodoException extends RuntimeException {

    public TodoException(String msg) {
        super(String.format("Todo: %s", msg));
    }

}
