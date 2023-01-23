package com.exalt.coursemanagementplatform.exception.notfoundexception;

/**
 * The LecturerNotFoundException class is an exception which will be
 * thrown when there won't be lecturer with specified PD.
 */
public class LecturerNotFoundException extends ClassNotFoundException {
    private static final String MESSAGE = "Lecturer not found";

    public LecturerNotFoundException(){
        super(MESSAGE);
    }
}
