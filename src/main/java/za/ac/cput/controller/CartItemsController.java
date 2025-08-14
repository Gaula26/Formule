package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItems;
import za.ac.cput.service.CartItemsService;

import java.util.List;

@RestController
@RequestMapping
public class CartItemsController {
    public CartItemsService service;

    @Autowired
    public CartItemsController(CartItemsService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public CartItems create(@RequestBody CartItems cartItems) {
        return service.create(cartItems);
    }

    @PostMapping("/update")
    public CartItems update(@RequestBody CartItems cartItems) {
        return service.update(cartItems);
    }

    @PostMapping("/read/id")
    public CartItems read(@PathVariable Integer id) {
        return service.read(id);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
       service.delete(id);

    }

    @GetMapping("/getAll")
    public Iterable<CartItems> getAll() {
        return service.getAll();
    }
    }

