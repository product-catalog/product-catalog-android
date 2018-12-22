package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class PhotoDto implements Serializable {
    private String name;
    private String picture;

    public PhotoDto(String name, String picture) {
        setName(name);
        setPicture(picture);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
