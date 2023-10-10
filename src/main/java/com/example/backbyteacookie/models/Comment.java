package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "comments")
@Builder

public record Comment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        int author_id,
        int recipe_id,
        int rating,
        String body,
        ZonedDateTime date)

    {

}
