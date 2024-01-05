package com.gabriel.project.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestProduct  (@NotNull UUID id, @NotBlank String name, @NotBlank String description, @NotBlank Double price, @NotBlank String imgUrl){
}
