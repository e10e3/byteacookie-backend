package com.example.backbyteacookie.DAO;

import com.example.backbyteacookie.models.Comment;
import com.example.backbyteacookie.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE r.user.id = :userId")
    List<Recipe> findRecipesByUserId(Long userId);
}
