package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.ZonedDateTime;

@Entity
@Table(name = "comments")
@Builder

public record Comment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "author_id")
        User author,
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "recipe_id")
        Recipe recipe,
        int rating,
        String body,
        ZonedDateTime date) {
}
