package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.time.ZonedDateTime;
import java.time.*;
import java.util.List;

@Entity
@Table(name = "recipes")
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
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "author_id")
        User user,
        ZonedDateTime date,

        @ManyToMany
        @JoinTable(
                name = "ingredient_recipe",
                joinColumns = @JoinColumn(name = "ingredient_id"),
                inverseJoinColumns = @JoinColumn(name = "recipe_id"))
        List<Ingredient> ingredients,

        @OneToMany(mappedBy = "recipe_id")
        List<Comment> comments
) {

}
