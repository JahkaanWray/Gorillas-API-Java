package com.example.gorillasclone.model;

import jakarta.persistence.Entity;

@Entity
public record Product(int id, String name) {
}