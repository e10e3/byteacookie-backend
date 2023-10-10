package com.example.backbyteacookie.services;

import com.example.backbyteacookie.DAO.IngredientDao;
import com.example.backbyteacookie.models.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientDao ingredientDao;
    public List<Ingredient> findAll() {
        return ingredientDao.findAll();
    }
}
