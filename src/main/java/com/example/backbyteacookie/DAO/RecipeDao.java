package com.example.backbyteacookie.DAO;

import com.example.backbyteacookie.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Long> {
}
