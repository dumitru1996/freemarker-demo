package com.freemarker.demo.exceptions;

public class DemoException extends RuntimeException {

    public DemoException(String cause) {
        super(cause);
    }

    public DemoException(String cause, Exception e) {
        super(cause, e);
    }
}
