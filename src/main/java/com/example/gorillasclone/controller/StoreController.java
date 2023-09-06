package com.example.gorillasclone.controller;

import com.example.gorillasclone.model.Store;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {
    private List<Store> storeList = new ArrayList<Store>();

    private int storeIdCounter = 1;

    @GetMapping("/stores")
    public List<Store> storeList() {
        return storeList;
    }

    @GetMapping("/stores/{id}")
    public Store store(@PathVariable int id) {
        Optional<Store> result = storeList.stream().filter(store -> store.id() == id).findFirst();
        return result.orElse(null);
    }

    @PostMapping("/stores")
    public Store newStore(@RequestBody Store store) {
        Store newStore = new Store(storeIdCounter, store.name());
        storeList.add(newStore);
        storeIdCounter++;
        return newStore;
    }
}