package com.example.gorillasclone.model;

import jakarta.persistence.Entity;

@Entity
public record Customer(int id, String name) {
}