package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;
import com.pcatalog.productcatalog.enums.ApplicationType;

import java.io.Serializable;

public class ApplyingForFirstDigitalTachographCardDto implements Serializable {
    private ApplicationType applicationType;
    private ApplicationStatus applicationStatus;
    private PersonalDetailsDto personalDetailsDto;
    private PhotoDto selfiePhoto;
    private PhotoDto idCardPhoto;
    private PhotoDto drivingLicensePhoto;
    private PhotoDto signatureForDeclarationPhoto;
    private DrivingLicenseDto drivingLicenseDto;

    protected ApplyingForFirstDigitalTachographCardDto(){}

    public ApplyingForFirstDigitalTachographCardDto(ApplicationType applicationType, ApplicationStatus applicationStatus, PersonalDetailsDto personalDetailsDto, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, DrivingLicenseDto drivingLicenseDto) {
        this.applicationType = applicationType;
        this.applicationStatus = applicationStatus;
        this.personalDetailsDto = personalDetailsDto;
        this.selfiePhoto = selfiePhoto;
        this.idCardPhoto = idCardPhoto;
        this.drivingLicensePhoto = drivingLicensePhoto;
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
        this.drivingLicenseDto = drivingLicenseDto;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public PersonalDetailsDto getPersonalDetailsDto() {
        return personalDetailsDto;
    }

    public void setPersonalDetailsDto(PersonalDetailsDto personalDetailsDto) {
        this.personalDetailsDto = personalDetailsDto;
    }

    public PhotoDto getSelfiePhoto() {
        return selfiePhoto;
    }

    public void setSelfiePhoto(PhotoDto selfiePhoto) {
        this.selfiePhoto = selfiePhoto;
    }

    public PhotoDto getIdCardPhoto() {
        return idCardPhoto;
    }

    public void setIdCardPhoto(PhotoDto idCardPhoto) {
        this.idCardPhoto = idCardPhoto;
    }

    public PhotoDto getDrivingLicensePhoto() {
        return drivingLicensePhoto;
    }

    public void setDrivingLicensePhoto(PhotoDto drivingLicensePhoto) {
        this.drivingLicensePhoto = drivingLicensePhoto;
    }

    public PhotoDto getSignatureForDeclarationPhoto() {
        return signatureForDeclarationPhoto;
    }

    public void setSignatureForDeclarationPhoto(PhotoDto signatureForDeclarationPhoto) {
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
    }

    public DrivingLicenseDto getDrivingLicenseDto() {
        return drivingLicenseDto;
    }

    public void setDrivingLicenseDto(DrivingLicenseDto drivingLicenseDto) {
        this.drivingLicenseDto = drivingLicenseDto;
    }
}
