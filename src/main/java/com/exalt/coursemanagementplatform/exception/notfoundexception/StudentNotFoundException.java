package com.exalt.coursemanagementplatform.exception.notfoundexception;

/**
 * The StudentNotFoundException class is an exception which will be
 * thrown when there won't be student with specified PD.
 */
public class StudentNotFoundException extends ClassNotFoundException {
    private static final String MESSAGE = "Student not found";

    public StudentNotFoundException(){
        super(MESSAGE);
    }
}
