package com.example.coursemanagementplatform.rest;

import com.example.coursemanagementplatform.soap.SoapProperties;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/api")
public class CourseManagementPlatformApplication extends Application {
    static {
        new SoapProperties().init();
    }
}
