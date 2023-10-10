package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
public record User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        String email,
        String password,
        @OneToMany(mappedBy = "author_id")
        List<Recipe> recipes,
        @OneToMany(mappedBy = "author_id")
        List<Comment> comments) {
}
