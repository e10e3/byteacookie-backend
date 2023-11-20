package com.example.backbyteacookie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "ingredient_recipe")
@Builder
@Data
@AllArgsConstructor
public class RecipeIngredientQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    @JsonIgnore
    Recipe recipe;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;
    float quantity;

    public RecipeIngredientQuantity() {
    }
}
