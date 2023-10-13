package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "recipes")
@Builder
@Data
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte[] image;
    private String description;
    private Difficulty difficulty;
    private Duration time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;
    private ZonedDateTime date;
    @ManyToMany
    @JoinTable(
            name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Ingredient> ingredients;
    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;

    public Recipe() {
    }
}
