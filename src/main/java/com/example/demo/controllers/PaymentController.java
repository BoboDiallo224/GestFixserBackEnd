package com.example.demo.controllers;

import com.example.demo.entities.PaymentExpenseType;
import com.example.demo.services.PaymentExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense/payment")
@CrossOrigin(value = "*")
public class PaymentController {

    private final PaymentExpenseService paymentExpenseService;

    @Autowired
    public PaymentController(PaymentExpenseService paymentExpenseService) {
        this.paymentExpenseService = paymentExpenseService;
    }

    @PostMapping("add/{id_expense}")
    public PaymentExpenseType addPayment(@RequestBody PaymentExpenseType paymentExpenseType,@PathVariable Long id_expense){
        return paymentExpenseService.savePayment(id_expense,paymentExpenseType);
    }

    @GetMapping(" /{id_expense}")
    public List<PaymentExpenseType> getSomeExpense(@PathVariable Long id_expense){
        return paymentExpenseService.getSomePayments(id_expense);
    }

    @GetMapping("find_by_expense/{id_expense}")
    public List<PaymentExpenseType> getPayementByExpense(@PathVariable Long id_expense){
        return paymentExpenseService.findPayementByExpense(id_expense);
    }


}
