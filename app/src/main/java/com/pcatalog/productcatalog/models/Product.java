package com.pcatalog.productcatalog.models;

import java.util.Date;

public class Product {

    private Long recordId;
    private Date recordCreated;
    private Date recordLastTimeEdited;
    private String name;
    private String description;
    private PhotoDto photoDto;
    private Double price;

    public Product(Long recordId, Date recordCreated, Date recordLastTimeEdited, String name, String description, PhotoDto photoDto, Double price) {
        setRecordId(recordId);
        setRecordCreated(recordCreated);
        setRecordLastTimeEdited(recordLastTimeEdited);
        setName(name);
        setDescription(description);
        setPhotoDto(photoDto);
        setPrice(price);
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getRecordCreated() {
        return recordCreated;
    }

    public void setRecordCreated(Date recordCreated) {
        this.recordCreated = recordCreated;
    }

    public Date getRecordLastTimeEdited() {
        return recordLastTimeEdited;
    }

    public void setRecordLastTimeEdited(Date recordLastTimeEdited) {
        this.recordLastTimeEdited = recordLastTimeEdited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhotoDto getPhotoDto() {
        return photoDto;
    }

    public void setPhotoDto(PhotoDto photoDto) {
        this.photoDto = photoDto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
