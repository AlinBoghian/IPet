package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Document(collection = "sightings")
@Table(name = "sightings", uniqueConstraints = { @UniqueConstraint(columnNames = { "lost_id" }),
        @UniqueConstraint(columnNames = { "user_id" }) })
public class Sighting {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lost_id") //create foreign key linking Sighting to Lost
    //one Lost animal has multiple sightings
    private Lost lost;
    @NotBlank
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotBlank
    private Location location;

    public Sighting(Lost lost, User user, Location location) {
        this.lost = lost;
        this.user = user;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Lost getLost() {
        return lost;
    }

    public User getUser() {
        return user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLost(Lost lost) {
        this.lost = lost;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
