package com.exalt.coursemanagementplatform.exception.notfoundexception;

/**
 * The HomeworkNotFoundException class is an exception which will be
 * thrown when there won't be homework with specified PD.
 */
public class HomeworkNotFoundException extends ClassNotFoundException {
    private static final String MESSAGE = "Homework not found";

    public HomeworkNotFoundException(){
        super(MESSAGE);
    }
}
