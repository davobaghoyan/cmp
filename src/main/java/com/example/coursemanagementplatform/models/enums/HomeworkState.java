package com.example.coursemanagementplatform.models.enums;


import java.util.Arrays;

public enum HomeworkState {

     NEW("new"), READ("read"), REVIEWED("reviewed"), GRADED("graded");

    private final String displayName;

    HomeworkState(String displayName) {
        this.displayName = displayName;
    }

    public static HomeworkState getEnumByValue(String value) {
        return Arrays.stream(values())
                .filter(hws -> hws.getDisplayName().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getDisplayName() {
        return displayName;
    }
}
