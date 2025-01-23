package com.ansh.restSpring.exception;

public class TableNotFoundException extends RuntimeException {

    public TableNotFoundException(String msg) {
        super(msg);

    }

}
