package com.example.backbyteacookie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

    public Ingredient() {
    }
}
