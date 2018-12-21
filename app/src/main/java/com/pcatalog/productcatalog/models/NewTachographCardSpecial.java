package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class NewTachographCardSpecial implements Serializable {
    private String issuingAuthority;
    private DrivingLicenseCategory drivingLicenseCategory;
    private EUCountry issuingCountry;

    public NewTachographCardSpecial(String issuingAuthority, DrivingLicenseCategory drivingLicenseCategory, EUCountry issuingCountry) {
        setIssuingAuthority(issuingAuthority);
        setDrivingLicenseCategory(drivingLicenseCategory);
        setIssuingCountry(issuingCountry);
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public DrivingLicenseCategory getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }

    public void setDrivingLicenseCategory(DrivingLicenseCategory drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public EUCountry getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(EUCountry issuingCountry) {
        this.issuingCountry = issuingCountry;
    }
}
