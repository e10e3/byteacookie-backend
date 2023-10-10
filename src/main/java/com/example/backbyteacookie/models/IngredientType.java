package com.example.backbyteacookie.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IngredientType {
    DISCREET ("discreet"),
    MASS ("mass"),
    VOLUME ("volume");

    private final String name;
}
