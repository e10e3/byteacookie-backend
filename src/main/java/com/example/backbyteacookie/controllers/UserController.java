package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Comment;
import com.example.backbyteacookie.models.Recipe;
import com.example.backbyteacookie.models.User;
import com.example.backbyteacookie.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    @Operation(summary = "Get a list of all existing users")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific user by its ID")
    public User getUserById(@Parameter(description = "ID of the user to get", required = true) @PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a given user")
    public void deleteUser(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a given user")
    public void updateUser(@PathVariable Long id) {
    }

    @GetMapping("/byName")
    @Operation(summary = "Get all users with a matching name")
    public List<User> getUserByName(@RequestParam String name) {
        return new ArrayList<>();
    }

    @GetMapping("/byEmail")
    @Operation(summary = "Get the user with a matching email address")
    public User getUserByEmail(@RequestParam String email) {
        return null;
    }

    @GetMapping("/{id}/recipes")
    @Operation(summary = "Get all recipes created by a given user")
    public List<Recipe> getRecipesFromUser(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping("/{id}/comments")
    @Operation(summary = "Get all reviews posted by a given user")
    public List<Comment> getCommentsFromUser(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping(value = "/{id}/picture", produces = MediaType.ALL_VALUE)
    @Operation(summary = "Get a given user's profile picture")
    public void getProfilePicture(@PathVariable Long id) {
    }

    @PutMapping(value = "/{id}/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    @Operation(summary = "Change a given user's profile picture")
    public void setProfilePicture(@PathVariable Long id) {
    }
}
