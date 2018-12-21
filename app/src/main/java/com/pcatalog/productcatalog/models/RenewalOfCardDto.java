package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;
import com.pcatalog.productcatalog.enums.ApplicationType;
import com.pcatalog.productcatalog.enums.RenewalOfCardReason;

import java.io.Serializable;
import java.util.Date;

public class RenewalOfCardDto implements Serializable {
    private ApplicationType applicationType;
    private ApplicationStatus applicationStatus;
    private PersonalDetailsDto personalDetails;
    private PhotoDto selfiePhoto;
    private PhotoDto idCardPhoto;
    private PhotoDto drivingLicensePhoto;
    private PhotoDto signatureForDeclarationPhoto;
    private PhotoDto previousTachographCardPhoto;
    private RenewalOfCardReason renewalOfCardReason;
    private EUCountry countryOfIssuing;
    private String issuingAuthority;
    private String tachographCardNumber;
    private Date dateOfExpir;

    protected RenewalOfCardDto(){}

    public RenewalOfCardDto(PersonalDetailsDto personalDetails, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, PhotoDto previousTachographCardPhoto, RenewalOfCardReason renewalOfCardReason, EUCountry countryOfIssuing, String issuingAuthority, String tachographCardNumber, Date dateOfExpir) {
        setApplicationType(applicationType.RENEWAL);
        setApplicationStatus(ApplicationStatus.PENDING);
        this.personalDetails = personalDetails;
        this.selfiePhoto = selfiePhoto;
        this.idCardPhoto = idCardPhoto;
        this.drivingLicensePhoto = drivingLicensePhoto;
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
        this.previousTachographCardPhoto = previousTachographCardPhoto;
        this.renewalOfCardReason = renewalOfCardReason;
        this.countryOfIssuing = countryOfIssuing;
        this.issuingAuthority = issuingAuthority;
        this.tachographCardNumber = tachographCardNumber;
        this.dateOfExpir = dateOfExpir;
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

    public PersonalDetailsDto getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsDto personalDetails) {
        this.personalDetails = personalDetails;
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

    public RenewalOfCardReason getRenewalOfCardReason() {
        return renewalOfCardReason;
    }

    public void setRenewalOfCardReason(RenewalOfCardReason renewalOfCardReason) {
        this.renewalOfCardReason = renewalOfCardReason;
    }

    public EUCountry getCountryOfIssuing() {
        return countryOfIssuing;
    }

    public void setCountryOfIssuing(EUCountry countryOfIssuing) {
        this.countryOfIssuing = countryOfIssuing;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getTachographCardNumber() {
        return tachographCardNumber;
    }

    public void setTachographCardNumber(String tachographCardNumber) {
        this.tachographCardNumber = tachographCardNumber;
    }

    public Date getDateOfExpir() {
        return dateOfExpir;
    }

    public void setDateOfExpir(Date dateOfExpir) {
        this.dateOfExpir = dateOfExpir;
    }
}
