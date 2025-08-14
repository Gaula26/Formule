/*
Author: Annah Gaula Manda (230164250)
Date: 08/08/2025
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItems;
import za.ac.cput.repository.CartItemsRepository;

import java.util.List;

@Service
public class CartItemsService implements ICartItemsService {
    private final CartItemsRepository repository;

    @Autowired
    public CartItemsService(CartItemsRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartItems create(CartItems cartItems) {
        return repository.save(cartItems);
    }

    @Override
    public CartItems read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CartItems update(CartItems cartItems) {
        return repository.save(cartItems);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<CartItems> getAll() {
        return List.of();
    }
}
