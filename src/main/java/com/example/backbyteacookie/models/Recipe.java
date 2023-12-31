package com.example.backbyteacookie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

import static org.hibernate.type.SqlTypes.INTERVAL_SECOND;

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
    @OneToOne(orphanRemoval = true)
    private Image image;
    private String description;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @JdbcTypeCode(INTERVAL_SECOND)
    private Duration time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;
    private ZonedDateTime date;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredientQuantity> ingredientQuantities;
    @OneToMany(mappedBy = "recipe")
    @JsonIgnore
    private List<Comment> comments;

    public Recipe() {
    }
}
