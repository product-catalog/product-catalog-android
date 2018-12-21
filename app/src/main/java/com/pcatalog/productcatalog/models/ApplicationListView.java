package com.pcatalog.productcatalog.models;

public class ApplicationListView {
    private int id;
    private String applicationType;
    private String username;
    private String applicationStatus;

    public ApplicationListView(int id, String applicationType, String username, String applicationStatus) {
        this.id = id;
        this.applicationType = applicationType;
        this.username = username;
        this.applicationStatus = applicationStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
