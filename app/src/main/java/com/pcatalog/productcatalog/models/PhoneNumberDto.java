package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class PhoneNumberDto implements Serializable {
    private EUCountry countryNumber;

    private String number;

    public PhoneNumberDto(EUCountry countryNumber, String number) {
        setCountryNumber(countryNumber);
        setNumber(number);
    }

    public EUCountry getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(EUCountry countryNumber) {
        this.countryNumber = countryNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
