package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Document(collection = "veterinaries")
@Table(name = "veterinaries")
public class VetCabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vet_id")
    private String id;
    @NotBlank
    @Column(name = "vet_name")
    private String name;

    @NotBlank
    @Column(name = "vet_user")
    private User user;
    @NotBlank
    @Size(min=10,max=10)
    @Column(name = "phone")
    private String phone;
    @NotBlank
    @Column(name = "location")
    private Location location;

    @NotBlank
    @JsonIgnore
    @Column(name = "reviews")
    private List<Review> reviews;
    public VetCabinet() {
    }

    public VetCabinet(User user, String phone, Location location) {
        this.user = user;
        this.phone = phone;
        this.location = location;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public String getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
