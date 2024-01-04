package com.gabriel.project.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record RequestOrder(@NotNull UUID id, @NotBlank Instant moment, @NotBlank Person client) {
}


