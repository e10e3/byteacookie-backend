package com.example.backbyteacookie.DAO;

import com.example.backbyteacookie.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
}
