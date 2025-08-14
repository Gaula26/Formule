/*
Author: Annah Gaula Manda (230164250)
Date: 08/08/2025
 */

package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CartItems;
import za.ac.cput.factory.CartItemsFactory;


import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemsServiceTest {



    @Autowired
    private static ICartItemsService service;

    private static CartItems cartItem = CartItemsFactory.createCartItems(
            101,
            "Garnier",
            3,
            150.00
    );



    @Test
    void a_create() {
        CartItems created = service.create(cartItem);
        assertNotNull(created);
        System.out.println(created);
    }



    @Test
    void b_read() {
        CartItems read = service.read(cartItem.getId());
        assertNotNull(read);
        System.out.println(read);
    }



    @Test
    void c_update() {
        CartItems newCartItem = new CartItems.Builder()
                .copy(cartItem)
                .setQuantity(5)
                .build();
        CartItems updated = service.update(newCartItem);
        assertNotNull(updated);
        System.out.println(updated);
    }



    @Test
    void e_delete() {
        assertTrue(service.delete(cartItem.getId());
        System.out.println("Deleted");
    }



    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}
