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
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.domain.PaymentStatus;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {



    @Autowired
    private static IPaymentService service;

    private static Payment payment = PaymentFactory.createPayment(
            01,
            "C101",
            450.00,
            "Credit Card",
            "26 05 2025",
            CANCELED
    );

    @Test
    void a_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        System.out.println(created);
    }



    @Test
    void b_read() {
        Payment read = service.read(payment.getId());
        assertNotNull(read);
        System.out.println(read);
    }



    @Test
    void c_update() {
        Payment newPayment = new Payment.Builder()
                .copy(payment)
                .setAmount(500.00)
                .build();
        Payment updated = service.update(newPayment);
        assertNotNull(updated);
        System.out.println(updated);
    }



    @Test
    void e_delete() {
        assertTrue(service.delete(payment.getId());
        System.out.println("Deleted");
    }



    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}
