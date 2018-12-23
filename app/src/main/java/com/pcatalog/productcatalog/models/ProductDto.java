package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private String name;
    private String description;
    private PhotoDto photo;
    private Double price;

    public ProductDto(String name, String description, PhotoDto photo, Double price) {
        setName(name);
        setDescription(description);
        setPhoto(photo);
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

    public PhotoDto getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDto photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
