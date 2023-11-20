package com.example.backbyteacookie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ingredients")
@Builder
@Data
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(orphanRemoval = true)
    private Image image;
    @Enumerated(EnumType.STRING)
    private IngredientType type;
    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private List<RecipeIngredientQuantity> recipesFeaturedIn;

    public Ingredient() {
    }
}
