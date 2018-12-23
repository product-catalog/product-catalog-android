package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class PhotoDto implements Serializable {
    private String name;
    private String photo;

    public PhotoDto(String name, String photo) {
        setName(name);
        setPhoto(photo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
