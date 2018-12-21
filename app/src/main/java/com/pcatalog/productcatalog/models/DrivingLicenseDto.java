package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class DrivingLicenseDto implements Serializable {
    private EUCountry issuingCountry;
    private DrivingLicenseCategory drivingLicenseCategory;
    private String issuingAuthority;

    protected DrivingLicenseDto(){}

    public DrivingLicenseDto(EUCountry issuingCountry, DrivingLicenseCategory drivingLicenseCategory, String issuingAuthority) {
        setIssuingCountry(issuingCountry);
        setDrivingLicenseCategory(drivingLicenseCategory);
        setIssuingAuthority(issuingAuthority);
    }

    public EUCountry getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(EUCountry issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public DrivingLicenseCategory getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }

    public void setDrivingLicenseCategory(DrivingLicenseCategory drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }
}

