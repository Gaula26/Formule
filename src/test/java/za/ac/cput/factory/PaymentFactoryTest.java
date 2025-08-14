
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
                "Annah",
                "Manda",
                "0125361487",
                "annamanda123@gmail.com",
                "Anna123!",
                "",
                1
        );
        Date date = new Date();
        Payment payment = PaymentFactory.createPayment(
                122,
                customer,
                100.50,
                PaymentMethod.CASH,
                date,
                Status.FAILED // Assuming Status.COMPLETED is a valid enum value
        );

        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void createPaymentWithInvalidData() {
        Customer customer = CustomerFactory.createCustomer(
                "Sisanda",
                "Madikizela",
                "074123456",
                "madikizsisanda@gmail.com",
                "sisanda123#",
                "AB123",
                1
        );
        Date date = new Date();
        Payment payment = PaymentFactory.createPayment(
                0,
                customer,
                100.50,
                PaymentMethod.CASH,
                date,
                Status.PENDING
        );

        assertNotNull(payment);
        System.out.println(payment);
    }
}