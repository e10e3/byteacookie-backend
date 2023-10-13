package com.example.backbyteacookie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Recipe> recipes;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Comment> comments;

    public User() {
    }
}
