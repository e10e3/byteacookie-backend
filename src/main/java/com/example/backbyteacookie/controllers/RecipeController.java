package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Comment;
import com.example.backbyteacookie.models.Difficulty;
import com.example.backbyteacookie.models.Ingredient;
import com.example.backbyteacookie.models.Recipe;
import com.example.backbyteacookie.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("recipes")
@RestController
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("")
    @Operation(summary = "Get a list of all existing recipes")
    public List<Recipe> listRecipes() {
        return recipeService.findAll();
    }

    @PostMapping("")
    @Operation(summary = "Create a new recipe")
    public void addRecipe(@RequestBody Recipe recipe) {
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific recipe by its ID")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a given recipe")
    public void deleteRecipe(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a given recipe")
    public void updateRecipe(@PathVariable Long id) {
    }

    @GetMapping("/difficulty")
    @Operation(summary = "Get all recipes of a given difficulty")
    public List<Recipe> getRecipesByDifficulty(@RequestParam Difficulty difficulty) {
        return new ArrayList<>();
    }

    @GetMapping("/duration")
    @Operation(summary = "Get all recipes of a given duration")
    public List<Recipe> getRecipesByDuration(@RequestParam Duration duration) {
        return new ArrayList<>();
    }

    @GetMapping("/date")
    @Operation(summary = "Get all recipes published on a given data")
    public List<Recipe> getRecipesByDate(@RequestParam LocalDate date) {
        return new ArrayList<>();
    }

    @GetMapping("/{id}/ingredients")
    @Operation(summary = "Get all ingredients used in a given recipe")
    public List<Ingredient> getIngredientsForRecipe(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping("/{id}/comments")
    @Operation(summary = "Get all reviews made for a given recipe")
    public List<Comment> getCommentsForRecipe(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping(value = "/{id}/picture", produces = MediaType.ALL_VALUE)
    @Operation(summary = "Get a given recipe's illustration")
    public void getIllustration(@PathVariable Long id) {
    }

    @PutMapping(value = "/{id}/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    @Operation(summary = "Change a given recipe's illustration")
    public void setIllustration(@PathVariable Long id) {
    }
}
