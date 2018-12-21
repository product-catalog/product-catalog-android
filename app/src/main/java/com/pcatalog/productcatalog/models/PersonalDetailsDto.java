package com.pcatalog.productcatalog.models;

import java.io.Serializable;
import java.util.Date;

public class PersonalDetailsDto implements Serializable {
    private String egn;

    private String firstName;

    private String middleNames;

    private String surname;

    private Date dateOfBirth;

    private String email;

    private AddressDto addressDto;

    private PhoneNumberDto phoneNumberDto;

    public PersonalDetailsDto(String egn, String firstName, String middleNames, String surname, Date dateOfBirth, String email, AddressDto addressDto, PhoneNumberDto phoneNumberDto) {
        setEgn(egn);
        setFirstName(firstName);
        setMiddleNames(middleNames);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setAddressDto(addressDto);
        setPhoneNumberDto(phoneNumberDto);
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public PhoneNumberDto getPhoneNumberDto() {
        return phoneNumberDto;
    }

    public void setPhoneNumberDto(PhoneNumberDto phoneNumberDto) {
        this.phoneNumberDto = phoneNumberDto;
    }
}
