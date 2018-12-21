package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class PhotoDto implements Serializable {
    private String picture;

    public PhotoDto(String picture) {
        setPicture(picture);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
