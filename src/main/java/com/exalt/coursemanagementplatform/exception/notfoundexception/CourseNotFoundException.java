package com.exalt.coursemanagementplatform.exception.notfoundexception;

/**
 * The CourseAlreadyExistsException class is an exception which will be
 * thrown when there won't be course with specified PD.
 */
public class CourseNotFoundException extends ClassNotFoundException {
    private static final String MESSAGE = "Course not found";

    public CourseNotFoundException(){
        super(MESSAGE);
    }
}
