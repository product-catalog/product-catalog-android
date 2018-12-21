package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String username;

    private String password;

    private String email;

    private DrivingLicenseDto drivingLicenseDto;

    private PersonalDetailsDto personalDetailsDto;

    protected UserDto(){}

    public UserDto(String username, String password, String email, DrivingLicenseDto drivingLicenseDto) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setDrivingLicenseDto(drivingLicenseDto);
    }

    public PersonalDetailsDto getPersonalDetailsDto() {
        return personalDetailsDto;
    }

    public void setPersonalDetailsDto(PersonalDetailsDto personalDetailsDto) {
        this.personalDetailsDto = personalDetailsDto;
    }

    public DrivingLicenseDto getDrivingLicenseDto() {
        return drivingLicenseDto;
    }

    public void setDrivingLicenseDto(DrivingLicenseDto drivingLicenseDto) {
        this.drivingLicenseDto = drivingLicenseDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

