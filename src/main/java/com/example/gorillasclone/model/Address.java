package com.example.gorillasclone.model;

import jakarta.persistence.Entity;
import org.springframework.data.util.Pair;

@Entity
public record Address(int id, String line1, Pair<Double, Double> coords) {
}