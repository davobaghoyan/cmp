package com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception;

import gnu.crypto.sasl.UserAlreadyExistsException;

/**
 * The StudentAlreadyExistsException class is an exception which will be
 * thrown in case to try to create student with an existing PK.
 */
public class StudentAlreadyExistsException extends UserAlreadyExistsException {
    private static final String MESSAGE = "Student with that id already exists.";

    public StudentAlreadyExistsException(){
        super(MESSAGE);
    }
}
