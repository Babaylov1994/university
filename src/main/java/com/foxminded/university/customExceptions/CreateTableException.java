package com.foxminded.university.customExceptions;

public class CreateTableException extends Exception{

    public CreateTableException(String message) {
        super(message);
    }

    public CreateTableException(String message, Throwable cause) {
        super(message, cause);
    }
}

