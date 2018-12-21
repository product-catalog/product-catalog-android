package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;
import com.pcatalog.productcatalog.enums.ApplicationType;

import java.io.Serializable;

public class ExchangingEUCardForBGCardDto implements Serializable{
    private ApplicationType applicationType;
    private ApplicationStatus applicationStatus;
    private PersonalDetailsDto personalDetailsDto;
    private PhotoDto selfiePhoto;
    private PhotoDto idCardPhoto;
    private PhotoDto drivingLicensePhoto;
    private PhotoDto signatureForDeclarationPhoto;
    private PhotoDto previousTachographCardPhoto;
    private EUCountry EUCountryOfIssuing;
    private String tachographCardNumber;
    private EUCountry countryOfIssuingOfDrivingLicense;
    private String drivingLicenseNumber;

    protected ExchangingEUCardForBGCardDto(){}

    public ExchangingEUCardForBGCardDto(ApplicationType applicationType, ApplicationStatus applicationStatus, PersonalDetailsDto personalDetailsDto, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, PhotoDto previousTachographCardPhoto, EUCountry EUCountryOfIssuing, String tachographCardNumber, EUCountry countryOfIssuingOfDrivingLicense, String drivingLicenseNumber) {
        setApplicationType(applicationType);
        setApplicationStatus(applicationStatus);
        setPersonalDetailsDto(personalDetailsDto);
        setSelfiePhoto(selfiePhoto);
        setIdCardPhoto(idCardPhoto);
        setDrivingLicensePhoto(drivingLicensePhoto);
        setSignatureForDeclarationPhoto(signatureForDeclarationPhoto);
        setPreviousTachographCardPhoto(previousTachographCardPhoto);
        setEUCountryOfIssuing(EUCountryOfIssuing);
        setTachographCardNumber(tachographCardNumber);
        setCountryOfIssuingOfDrivingLicense(countryOfIssuingOfDrivingLicense);
        setDrivingLicenseNumber(drivingLicenseNumber);
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

    public PhotoDto getPreviousTachographCardPhoto() {
        return previousTachographCardPhoto;
    }

    public void setPreviousTachographCardPhoto(PhotoDto previousTachographCardPhoto) {
        this.previousTachographCardPhoto = previousTachographCardPhoto;
    }

    public EUCountry getEUCountryOfIssuing() {
        return EUCountryOfIssuing;
    }

    public void setEUCountryOfIssuing(EUCountry EUCountryOfIssuing) {
        this.EUCountryOfIssuing = EUCountryOfIssuing;
    }

    public String getTachographCardNumber() {
        return tachographCardNumber;
    }

    public void setTachographCardNumber(String tachographCardNumber) {
        this.tachographCardNumber = tachographCardNumber;
    }

    public EUCountry getCountryOfIssuingOfDrivingLicense() {
        return countryOfIssuingOfDrivingLicense;
    }

    public void setCountryOfIssuingOfDrivingLicense(EUCountry countryOfIssuingOfDrivingLicense) {
        this.countryOfIssuingOfDrivingLicense = countryOfIssuingOfDrivingLicense;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
