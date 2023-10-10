package com.example.backbyteacookie.DAO;

import com.example.backbyteacookie.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.recipe.id = :recipeId")
    List<Comment> findByRecipeId(Long recipeId);
}
