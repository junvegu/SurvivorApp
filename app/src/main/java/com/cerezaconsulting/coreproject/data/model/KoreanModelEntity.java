package com.cerezaconsulting.coreproject.data.model;

import java.io.Serializable;

/**
 * Created by junior on 31/08/17.
 */

public class KoreanModelEntity implements Serializable {

    private String name;
    private String image;
    private String description;
    private String birth_date;


    public KoreanModelEntity(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
}
