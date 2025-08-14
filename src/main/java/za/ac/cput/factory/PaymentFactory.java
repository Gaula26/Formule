package za.ac.cput.factory;
/*

Author: Annah Gaula Manda (230164250)
Date: 20/04/2025
*/

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.Status;
import za.ac.cput.util.Helper;

import java.util.Date;

public class PaymentFactory {

    public static Payment createPayment(int id, Customer customer, double amount, PaymentMethod method, Date date, Status status) {

        if(!Helper.isValidAmount(amount)){
            return null;
        }

        if (customer == null) {
            return null;
        }

        if (method == null) {
            return null;
        }

        if (date == null) {
            return null;
        }

        return new Payment.Builder()
                .setId(id)
                .setCustomer(customer)
                .setAmount(amount)
                .setMethod(method)
                .setDate(date)
                .setStatus(status)
                .build();
    }
}