package com.example.gorillasclone.model;

import com.example.gorillasclone.model.Order;

public record OrderDetail(int id, Order order, Product product){}