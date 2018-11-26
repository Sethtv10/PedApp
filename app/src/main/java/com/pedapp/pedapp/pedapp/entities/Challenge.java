package com.pedapp.pedapp.pedapp.entities;

import java.io.Serializable;

public class Challenge implements Serializable{

    private Integer ID;
    private String CHALLENGE;
    private Integer CATEGORY;

    public Challenge (Integer  ID, String CHALLENGE, Integer CATEGORY){

        this.ID = ID;
        this.CHALLENGE = CHALLENGE;
        this.CATEGORY = CATEGORY;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCHALLENGE() {
        return CHALLENGE;
    }

    public void setCHALLENGE(String CHALLENGE) {
        this.CHALLENGE = CHALLENGE;
    }

    public Integer getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(Integer CATEGORY) {
        this.CATEGORY = CATEGORY;
    }
}
