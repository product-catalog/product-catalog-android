package com.pcatalog.productcatalog.models;

import java.io.Serializable;
import java.util.Date;

public class ProductEdit implements Serializable {
    private Long recordId;
    private Date recordCreated;
    private Date recordLastTimeEdited;
    private String name;
    private String description;
    private PhotoEditDto photo;
    private Double price;

    public ProductEdit(Long recordId, Date recordCreated, Date recordLastTimeEdited, String name, String description, PhotoEditDto photo, Double price) {
        setRecordId(recordId);
        setRecordCreated(recordCreated);
        setRecordLastTimeEdited(recordLastTimeEdited);
        setName(name);
        setDescription(description);
        setPhoto(photo);
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

    public PhotoEditDto getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoEditDto photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
