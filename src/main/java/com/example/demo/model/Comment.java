package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "body")
    @NotBlank
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(@NotBlank @Size(min = 10, message = "Comment body must be minimum 10 characters") String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }
}