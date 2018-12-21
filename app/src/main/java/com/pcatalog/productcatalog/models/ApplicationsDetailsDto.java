package com.pcatalog.productcatalog.models;

import com.pcatalog.productcatalog.enums.ApplicationStatus;
import com.pcatalog.productcatalog.enums.ApplicationType;
import com.pcatalog.productcatalog.enums.RenewalOfCardReason;
import com.pcatalog.productcatalog.enums.ReplacementOfCardReason;

import java.io.Serializable;
import java.util.Date;

public class ApplicationsDetailsDto implements Serializable {
    private Long recordId;
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
    private ReplacementOfCardReason replacementOfCardReason;
    private String issuingAuthority;
    private Date dateOfExprity;
    private Date lossOrTheftDate;
    private String lossOrTheftPlace;
    private RenewalOfCardReason renewalOfCardReason;
    private DrivingLicenseDto drivingLicenseDto;

    public ApplicationsDetailsDto(Long recordId, ApplicationType applicationType, ApplicationStatus applicationStatus, PersonalDetailsDto personalDetailsDto, PhotoDto selfiePhoto, PhotoDto idCardPhoto, PhotoDto drivingLicensePhoto, PhotoDto signatureForDeclarationPhoto, PhotoDto previousTachographCardPhoto, EUCountry EUCountryOfIssuing, String tachographCardNumber, EUCountry countryOfIssuingOfDrivingLicense, String drivingLicenseNumber, ReplacementOfCardReason replacementOfCardReason, String issuingAuthority, Date dateOfExprity, Date lossOrTheftDate, String lossOrTheftPlace, RenewalOfCardReason renewalOfCardReason, DrivingLicenseDto drivingLicenseDto) {
        this.recordId = recordId;
        this.applicationType = applicationType;
        this.applicationStatus = applicationStatus;
        this.personalDetailsDto = personalDetailsDto;
        this.selfiePhoto = selfiePhoto;
        this.idCardPhoto = idCardPhoto;
        this.drivingLicensePhoto = drivingLicensePhoto;
        this.signatureForDeclarationPhoto = signatureForDeclarationPhoto;
        this.previousTachographCardPhoto = previousTachographCardPhoto;
        this.EUCountryOfIssuing = EUCountryOfIssuing;
        this.tachographCardNumber = tachographCardNumber;
        this.countryOfIssuingOfDrivingLicense = countryOfIssuingOfDrivingLicense;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.replacementOfCardReason = replacementOfCardReason;
        this.issuingAuthority = issuingAuthority;
        this.dateOfExprity = dateOfExprity;
        this.lossOrTheftDate = lossOrTheftDate;
        this.lossOrTheftPlace = lossOrTheftPlace;
        this.renewalOfCardReason = renewalOfCardReason;
        this.drivingLicenseDto = drivingLicenseDto;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public ReplacementOfCardReason getReplacementOfCardReason() {
        return replacementOfCardReason;
    }

    public void setReplacementOfCardReason(ReplacementOfCardReason replacementOfCardReason) {
        this.replacementOfCardReason = replacementOfCardReason;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public Date getDateOfExprity() {
        return dateOfExprity;
    }

    public void setDateOfExprity(Date dateOfExprity) {
        this.dateOfExprity = dateOfExprity;
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

    public RenewalOfCardReason getRenewalOfCardReason() {
        return renewalOfCardReason;
    }

    public void setRenewalOfCardReason(RenewalOfCardReason renewalOfCardReason) {
        this.renewalOfCardReason = renewalOfCardReason;
    }

    public DrivingLicenseDto getDrivingLicenseDto() {
        return drivingLicenseDto;
    }

    public void setDrivingLicenseDto(DrivingLicenseDto drivingLicenseDto) {
        this.drivingLicenseDto = drivingLicenseDto;
    }
}
