package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "shelterInfo")
public class ShelterInfo {
    @Id
    private String id;
    private String phoneNr;
    private String Address;
    private ArrayList<String> adoptionList;

    public ShelterInfo(String phoneNr, String address, ArrayList<String> adoptionList) {
        this.phoneNr = phoneNr;
        Address = address;
        this.adoptionList = adoptionList;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public String getAddress() {
        return Address;
    }

    public ArrayList<String> getAdoptionList() {
        return adoptionList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setAdoptionList(ArrayList<String> adoptionList) {
        this.adoptionList = adoptionList;
    }
}
