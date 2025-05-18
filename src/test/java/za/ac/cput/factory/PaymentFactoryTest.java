
/*
PaymentFactoryTest.java
Test class for PaymentFactory
Author: Annah Gaula Manda (230164250)
Date: 20/04/2025
*/
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.Status;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentFactoryTest {

    @Test
    void createPayment() {
        Customer customer = CustomerFactory.createCustomer(
                1,
                "Annah",
                "Manda",
                "0841234567",
                "annamanda123@gmail.com",
                "Anna123!",
                1
        );
        Date date = new Date();
        Payment payment = PaymentFactory.createPayment(
                1,
                customer,
                100.50,
                PaymentMethod.SUCCESSFUL,
                date
        );

        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void createPaymentWithInvalidData() {
        Customer customer = CustomerFactory.createCustomer(
                1,
                "Sisanda",
                "Madikizela",
                "0741234567",
                "madsisanda@gmail.com",
                "sisanda123#",
                1
        );
        Date date = new Date();
        Payment payment = PaymentFactory.createPayment(
                0, // Invalid ID
                customer,
                100.50,
                PaymentMethod.SUCCESSFUL,
                date
        );

        assertNotNull(payment);
        System.out.println(payment);
    }
}