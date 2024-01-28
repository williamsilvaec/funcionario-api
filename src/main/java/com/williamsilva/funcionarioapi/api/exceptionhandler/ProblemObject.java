package com.williamsilva.funcionarioapi.api.exceptionhandler;

public class ProblemObject {

    private final String name;
    private final String userMessage;

    public ProblemObject(String name, String userMessage) {
        this.name = name;
        this.userMessage = userMessage;
    }

    public String getName() {
        return name;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
