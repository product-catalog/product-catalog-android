package com.pcatalog.productcatalog.models;

import java.io.Serializable;

public class PhotoDto implements Serializable {
    private String name;
    private byte[] photo;

    public PhotoDto(String name, byte[] photo) {
        setName(name);
        setPhoto(photo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
