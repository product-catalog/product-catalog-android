package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class AddressDto implements Serializable {
    private EUCountry country;

    private String area;

    private String city;

    private String street;

    public AddressDto(EUCountry country, String area, String city, String street) {
        setCountry(country);
        setArea(area);
        setCity(city);
        setStreet(street);
    }



    public EUCountry getCountry() {
        return country;
    }

    public void setCountry(EUCountry country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
