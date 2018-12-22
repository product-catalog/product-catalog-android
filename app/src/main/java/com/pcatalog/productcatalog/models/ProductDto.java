package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private String name;
    private String description;
    private PhotoDto photoDto;
    private Double price;

    public ProductDto(String name, String description, PhotoDto photoDto, Double price) {
        setName(name);
        setDescription(description);
        setPhotoDto(photoDto);
        setPrice(price);
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
