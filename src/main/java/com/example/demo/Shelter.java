package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shelters")
public class Shelter {
    @Id
    private String id;
    private String registrationNr;

    public Shelter() {
    }

    public Shelter(String registrationNr) {
        this.registrationNr = registrationNr;
    }

    public String getId() {
        return id;
    }

    public String getRegistrationNr() {
        return registrationNr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr;
    }
}
