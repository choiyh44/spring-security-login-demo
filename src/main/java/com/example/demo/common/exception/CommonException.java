package com.example.demo.common.exception;

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -8500819678064670508L;

    private String code;

    public CommonException() {
        super("Server error");
        this.code = "9000";
    }

    public CommonException(String code, String message) {
        super(message);
        this.code = code;
    }
}
