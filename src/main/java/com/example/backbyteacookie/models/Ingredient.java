package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "ingredients")
@Builder
public record Ingredient(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        String image,
        IngredientType type) {
}
