package com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception;

import gnu.crypto.sasl.UserAlreadyExistsException;

/**
 * The HomeworkAlreadyExistsException class is an exception which will be
 * thrown in case to try to create homework with an existing PK.
 */
public class HomeworkAlreadyExistsException extends UserAlreadyExistsException {
    private static final String MESSAGE = "Homework with that id already exists.";

    public HomeworkAlreadyExistsException(){
        super(MESSAGE);
    }
}
