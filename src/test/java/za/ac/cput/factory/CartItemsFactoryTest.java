/*
 * Author: Annah Manda (230164250)
 * Date: 18/05/2025
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Brands;
import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemsFactoryTest {

    @Test
    void createCartItems() {

        Product product = ProductFactory.createProduct(
                1001, "Innisfree Green Tea Serum", "Hydrating serum", 250.00, 10, 101, Brands.INNISFREE
        );
        int quantity = 2;
        Double totalItems = 250.00 * quantity;


        CartItems cartItems = CartItemsFactory.createCartItems(product, quantity, totalItems);


        assertNotNull(cartItems, "CartItems should not be null for valid inputs");
        System.out.println(cartItems);
    }

    @Test
    void createCartItemsWithInvalidData() {

        Product product = ProductFactory.createProduct(
                1001, "Innisfree Green Tea Serum", "Hydrating serum", 250.00, 10, 101, Brands.INNISFREE
        );
        int quantity = 2;
        Double totalItems = 250.00 * 3;


        CartItems cartItems = CartItemsFactory.createCartItems(product, quantity, totalItems);


        assertNull(cartItems, "CartItems should be null for invalid totalItems");
        System.out.println("CartItems with invalid data: " + cartItems);
    }

    @Test
    void createCartItemsWithAllAttributes() {

        Product product = ProductFactory.createProduct(
                1002, "Missha Time Revolution Essence", "Anti-aging essence", 350.00, 5, 102, Brands.MISSHA
        );
        int quantity = 3;
        Double totalItems = 350.00 * quantity;


        CartItems cartItems = CartItemsFactory.createCartItems(product, quantity, totalItems);


        assertNotNull(cartItems, "CartItems should not be null for valid inputs");
        System.out.println(cartItems);
    }

    @Test
    void testCreateCartItems() {

    }
}
