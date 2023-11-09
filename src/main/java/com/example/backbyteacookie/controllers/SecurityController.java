package com.example.backbyteacookie.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("")
@RestController
@RequiredArgsConstructor
public class SecurityController {

    @PostMapping("/login")
    @Operation(summary = "Start a session as a user")
    public void logUserIn(@RequestBody String email, @RequestBody String password) {
    }

    @GetMapping("/logout")
    @Operation(summary = "Stop your existing session")
    public void logUserOut() {
    }

    @PostMapping("/signup")
    @Operation(summary = "Create an account (and a user) for the service")
    public void signUp(@RequestBody String username, @RequestBody String email, @RequestBody String password) {
    }
}
