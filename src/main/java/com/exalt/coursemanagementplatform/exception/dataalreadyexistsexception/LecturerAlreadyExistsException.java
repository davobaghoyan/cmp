package com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception;

import gnu.crypto.sasl.UserAlreadyExistsException;

/**
 * The LecturerAlreadyExistsException class is an exception which will be
 * thrown in case to try to create Lecturer with an existing PK.
 */
public class LecturerAlreadyExistsException extends UserAlreadyExistsException {
    private static final String MESSAGE = "Lecturer with that id already exists.";

    public LecturerAlreadyExistsException(){
        super(MESSAGE);
    }
}
