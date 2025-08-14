/*
Author: Annah Gaula Manda (230164250)
Date: 08/08/2025
 */

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
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentStatus;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.domain.Customer;
import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.PaymentStatus.PENDING;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentControllerTest {

    private static Payment payment;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/formule/payment";

    @BeforeAll
    static void setUp() throws Exception {
        Customer customer;
        payment = PaymentFactory.createPayment(
                122,
                customer = CustomerFactory.createCustomer(
                        "Annah",
                        "Manda",
                        "0741254789",
                        "manann124@gmail.com",
                        "CAA145",
                        12),
                450.00,
                "CREDIT_CARD",
                "26 May 2025",
                PaymentStatus.PENDING,
        );
    }


    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        Payment saved = postResponse.getBody();
        assertEquals(payment.getId(), saved.getId());
        System.out.println("Created: " + saved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + payment.getId();
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url, Payment.class);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Payment updatedPayment = new Payment.Builder()
                .copy(payment)
                .setAmount(500.00)
                .build();
        String url = BASE_URL + "/update";
        ResponseEntity<Payment> response = this.restTemplate.postForEntity(url, updatedPayment, Payment.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(500.00, response.getBody().getAmount());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + payment.getId();
        this.restTemplate.delete(url);

        ResponseEntity<Payment> response = this.restTemplate.getForEntity(BASE_URL + "/read/" + payment.getId(), Payment.class);
        assertNull(response.getBody());
        System.out.println("Deleted: " + response.getBody());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Payment[]> response = this.restTemplate.getForEntity(url, Payment[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("GetAll: ");
        for (Payment p : response.getBody()) {
            System.out.println(p);
        }
    }
}

