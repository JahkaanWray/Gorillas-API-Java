package com.example.gorillasclone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public final class Order {

    @Id
    @GeneratedValue()
    private final int id;

    @OneToOne
    private Store store;

    @OneToMany
    private List<OrderDetail> orderDetails = new ArrayList<>();

    private Customer customer;
    private User picker;
    private Rider rider;


    public Order(int id, String customerName) {
        this.id = id;
    }

    public int id() {
        return id;
    }


    public Customer customer() {
        return customer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Order) obj;
        return this.id == that.id &&
                Objects.equals(this.customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer);
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id + ", " +
                "customerName=" + customer + ']';
    }


}