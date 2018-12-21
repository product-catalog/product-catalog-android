package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;
import com.pcatalog.productcatalog.enums.ApplicationType;
import com.pcatalog.productcatalog.enums.ReplacementOfCardReason;

import java.io.Serializable;
import java.util.Date;

public class ReplacementOfCardDto implements Serializable {
    private ApplicationType applicationType;
    private ApplicationStatus applicationStatus;
    private PersonalDetailsDto personalDetailsDto;
    private PhotoDto selfiePhoto;
    private PhotoDto idCardPhoto;
    private PhotoDto drivingLicensePhoto;
    private PhotoDto signatureForDeclarationPhoto;
    private PhotoDto previousTachographCardPhoto;
    private ReplacementOfCardReason replacementOfCardReason;
    private EUCountry countryOfIssuing;
    private String issuingAuthority;
    private String tachographCardNumber;
    private Date dateOfExpiry;
    private Date lossOrTheftDate;
    private String lossOrTheftPlace;

    protected ReplacementOfCardDto() {
    }

    public ReplacementOfCardDto(PersonalDetailsDto personalDetailsDto, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, PhotoDto previousTachographCardPhoto, ReplacementOfCardReason replacementOfCardReason, EUCountry countryOfIssuing, String issuingAuthority, String tachographCardNumber, Date dateOfExpiry, Date lossOrTheftDate, String lossOrTheftPlace) {
        setApplicationType(ApplicationType.REPLACEMENT);
        setApplicationStatus(ApplicationStatus.PENDING);
        this.personalDetailsDto = personalDetailsDto;
        this.selfiePhoto = selfiePhoto;
        this.idCardPhoto = idCardPhoto;
        this.drivingLicensePhoto = drivingLicensePhoto;
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
        this.previousTachographCardPhoto = previousTachographCardPhoto;
        this.replacementOfCardReason = replacementOfCardReason;
        this.countryOfIssuing = countryOfIssuing;
        this.issuingAuthority = issuingAuthority;
        this.tachographCardNumber = tachographCardNumber;
        this.dateOfExpiry = dateOfExpiry;
        this.lossOrTheftDate = lossOrTheftDate;
        this.lossOrTheftPlace = lossOrTheftPlace;
    }

    public ReplacementOfCardDto(PersonalDetailsDto personalDetailsDto, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, PhotoDto previousTachographCardPhoto, ReplacementOfCardReason replacementOfCardReason, EUCountry countryOfIssuing, String issuingAuthority, String tachographCardNumber, Date dateOfExpiry) {
        setApplicationType(ApplicationType.REPLACEMENT);
        setApplicationStatus(ApplicationStatus.PENDING);
        this.personalDetailsDto = personalDetailsDto;
        this.selfiePhoto = selfiePhoto;
        this.idCardPhoto = idCardPhoto;
        this.drivingLicensePhoto = drivingLicensePhoto;
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
        this.previousTachographCardPhoto = previousTachographCardPhoto;
        this.replacementOfCardReason = replacementOfCardReason;
        this.countryOfIssuing = countryOfIssuing;
        this.issuingAuthority = issuingAuthority;
        this.tachographCardNumber = tachographCardNumber;
        this.dateOfExpiry = dateOfExpiry;
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

    public ReplacementOfCardReason getReplacementOfCardReason() {
        return replacementOfCardReason;
    }

    public void setReplacementOfCardReason(ReplacementOfCardReason replacementOfCardReason) {
        this.replacementOfCardReason = replacementOfCardReason;
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

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public Date getLossOrTheftDate() {
        return lossOrTheftDate;
    }

    public void setLossOrTheftDate(Date lossOrTheftDate) {
        this.lossOrTheftDate = lossOrTheftDate;
    }

    public String getLossOrTheftPlace() {
        return lossOrTheftPlace;
    }

    public void setLossOrTheftPlace(String lossOrTheftPlace) {
        this.lossOrTheftPlace = lossOrTheftPlace;
    }
}
