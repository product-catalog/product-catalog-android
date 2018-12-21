package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;

public class ChangeApplicationStatusDto {
    private ApplicationStatus applicationStatus;
    private Long id;

    protected ChangeApplicationStatusDto(){}

    public ChangeApplicationStatusDto(ApplicationStatus applicationStatus, Long id) {
        this.applicationStatus = applicationStatus;
        this.id = id;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
