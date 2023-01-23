package com.exalt.coursemanagementplatform.rest;

import com.exalt.coursemanagementplatform.soap.SoapProperties;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The CourseManagementPlatformApplication is tha main class for application
 */
@ApplicationPath("/api")
public class CourseManagementPlatformApplication extends Application {
    static {
        new SoapProperties().init();
    }
}
