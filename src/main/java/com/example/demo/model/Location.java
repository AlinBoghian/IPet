package com.example.demo.model;

public class Location {
    private String street_name;
    private Long street_nr;
    private Long postal_code;

    public Location(String street_name, Long street_nr, Long postal_code) {
        this.street_name = street_name;
        this.street_nr = street_nr;
        this.postal_code = postal_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public Long getStreet_nr() {
        return street_nr;
    }

    public Long getPostal_code() {
        return postal_code;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public void setStreet_nr(Long street_nr) {
        this.street_nr = street_nr;
    }

    public void setPostal_code(Long postal_code) {
        this.postal_code = postal_code;
    }
}
