package com.example.backbyteacookie.services;

import com.example.backbyteacookie.DAO.RecipeDao;
import com.example.backbyteacookie.models.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeDao recipeDao;
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }
}
