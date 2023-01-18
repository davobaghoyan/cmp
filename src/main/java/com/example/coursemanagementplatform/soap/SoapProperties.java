package com.example.coursemanagementplatform.soap;

import javax.xml.ws.Endpoint;

public class SoapProperties {
    private static final String url = "http://localhost:8000/soap";
    public void init() {
        Endpoint.publish(url, new Soap());
    }
}
