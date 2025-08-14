/*
Author: Annah Gaula Manda (230164250)
Date: 08/08/2025
 */

package za.ac.cput.service;

import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment, Integer> {
    List<Payment> getAll();
}
