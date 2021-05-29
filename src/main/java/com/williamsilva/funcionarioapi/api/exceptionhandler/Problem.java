package com.williamsilva.funcionarioapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String title;
    private String detail;
    private String userMessage;
    private List<ProblemObject> objects;

    public Problem(Integer status, String title, String userMessage, String detail) {
        this.status = status;
        this.title = title;
        this.userMessage = userMessage;
        this.detail = detail;
        this.timestamp = OffsetDateTime.now();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public List<ProblemObject> getObjects() {
        return objects;
    }

    public void setObjects(List<ProblemObject> objects) {
        this.objects = objects;
    }

}
