package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Ingredient;
import com.example.backbyteacookie.models.IngredientType;
import com.example.backbyteacookie.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("ingredients")
@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("")
    @Operation(summary = "Get all existing ingredients")
    public List<Ingredient> listIngredients() {
        return ingredientService.findAll();
    }

    @PostMapping("")
    @Operation(summary = "Create a new ingredient")
    public void addIngredient(@RequestBody Ingredient ingredient) {
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific ingredient by its ID")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a given ingredient")
    public void deleteIngredient(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a given ingredient")
    public void updateIngredient(@PathVariable Long id) {
    }

    @GetMapping("/{id}/recipes")
    @Operation(summary = "Get all recipes that use a given ingredient")
    public List<Ingredient> getRecipesWithIngredient(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping("/byType")
    @Operation(summary = "Get all ingredients of a given type")
    public List<Ingredient> getIngredientsByType(@RequestParam IngredientType type) {
        return new ArrayList<>();
    }

    @GetMapping(value = "/{id}/picture", produces = MediaType.ALL_VALUE)
    @Operation(summary = "Get a given ingredient's image")
    public void getImage(@PathVariable Long id) {
    }

    @PutMapping(value = "/{id}/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    @Operation(summary = "Change a given ingredient's image")
    public void addImage(@PathVariable Long id) {
    }
}
