package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Ingredient;
import com.example.backbyteacookie.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("ingredients")
@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("")
    public List<Ingredient> listIngredients() {
        return ingredientService.findAll();
    }
    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }
}
