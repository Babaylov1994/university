package com.foxminded.university.exceptions;

public class DaoException extends RuntimeException{

    public DaoException(String massage) {
        super(massage);
    }

    public DaoException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
