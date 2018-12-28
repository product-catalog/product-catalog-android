package com.pcatalog.productcatalog.models;

import java.io.Serializable;
import java.util.Date;

public class PhotoEditDto implements Serializable {
    private Long recordId;
    private Date recordCreated;
    private Date recordLastTimeEdited;
    private String name;
    private byte[] photo;

    public PhotoEditDto(Long recordId, Date recordCreated, Date recordLastTimeEdited, String name, byte[] photo) {
        setRecordId(recordId);
        setRecordCreated(recordCreated);
        setRecordLastTimeEdited(recordLastTimeEdited);
        setName(name);
        setPhoto(photo);
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
