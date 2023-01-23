package com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception;

import gnu.crypto.sasl.UserAlreadyExistsException;

/**
 * The CourseAlreadyExistsException class is an exception which will be
 * thrown in case to try to create course with an existing PK.
 */
public class CourseAlreadyExistsException extends UserAlreadyExistsException {
    private static final String MESSAGE = "Course with that id already exists.";

    public CourseAlreadyExistsException(){
        super(MESSAGE);
    }
}
