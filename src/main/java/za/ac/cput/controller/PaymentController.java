package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping
public class PaymentController {
    public PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return service.update(payment);
    }

    @PostMapping("/read/id")
    public Payment read(@PathVariable Integer id) {
        return service.read(id);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);


    }

    @GetMapping("/getAll")
    public Iterable<Payment> getAll() {
        return service.getAll();
    }
}


