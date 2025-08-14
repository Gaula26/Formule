package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartItemsFactory;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemsControllerTest {

    private static CartItems cartItem;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/formule/cartitems";

    @BeforeAll
    static void setUp() {
        cartItem = CartItemsFactory.createCartItems(
                101,
                "P201 Garnier Facial cream" ,
                2,
                150.00
        )   ;
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<CartItems> postResponse = restTemplate.postForEntity(url, cartItem, CartItems.class);
        assertNotNull(postResponse);
        CartItems saved = postResponse.getBody();
        assertEquals(cartItem.getItemId(), saved.getItemId());
        System.out.println("Created: " + saved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + cartItem.getItemId();
        ResponseEntity<CartItems> response = this.restTemplate.getForEntity(url, CartItems.class);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        CartItems updatedCartItem = new CartItems.Builder()
                .copy(cartItem)
                .setQuantity(5)
                .build();
        String url = BASE_URL + "/update";
        ResponseEntity<CartItems> response = this.restTemplate.postForEntity(url, updatedCartItem, CartItems.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5, response.getBody().getQuantity());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + cartItem.getItemId();
        this.restTemplate.delete(url);

        ResponseEntity<CartItems> response = this.restTemplate.getForEntity(BASE_URL + "/read/" + cartItem.getItemId(), CartItems.class);
        assertNull(response.getBody());
        System.out.println("Deleted: " + response.getBody());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<CartItems[]> response = this.restTemplate.getForEntity(url, CartItems[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("GetAll: ");
        for (CartItems item : response.getBody()) {
            System.out.println(item);
        }
    }
}