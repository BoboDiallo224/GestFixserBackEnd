package com.example.demo.services;

import com.example.demo.entities.Expense;
import com.example.demo.entities.PaymentExpenseType;
import com.example.demo.repositories.ExpenseRepository;
import com.example.demo.repositories.PaymentExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentExpenseService {

    private final ExpenseRepository expenseRepository;
    private final PaymentExpenseRepository paymentExpenseRepository;

    @Autowired
    public PaymentExpenseService(ExpenseRepository expenseRepository, PaymentExpenseRepository paymentExpenseRepository) {
        this.expenseRepository = expenseRepository;
        this.paymentExpenseRepository = paymentExpenseRepository;
    }

    public PaymentExpenseType savePayment(Long id_expense,PaymentExpenseType paymentExpenseType){

        Expense expense = expenseRepository.findById(id_expense).get();
        paymentExpenseType.setExpenseInPaymentExpense(expense);

        return paymentExpenseRepository.save(paymentExpenseType);
    }

    public List<PaymentExpenseType> findPayementByExpense(Long id_expense){
        //Expense expense = expenseRepository.findById(id_expense).get();
        return paymentExpenseRepository.findByExpenseInPaymentExpenseOrderById_payment_expenseDesc(id_expense);
    }

    public List<PaymentExpenseType> getSomePayments(Long id_expense){
        return paymentExpenseRepository.findSomePaymentExpense(id_expense);
    }
}
