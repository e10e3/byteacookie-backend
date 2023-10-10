package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.Builder;


import java.time.ZonedDateTime;
import java.time.*;
import java.util.List;

@Entity
@Table(name = "recipe")
@Builder
public record Recipe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        byte[] image,
        String description,
        Difficulty difficulty,
        Duration time,
        Long author_id,
        ZonedDateTime date,

        @ManyToMany
        @JoinTable(
        name = "ingredient_recipe",
        joinColumns = @JoinColumn(name = "ingredient_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id"))
        List<Ingredient> ingredients
        ) {

}
