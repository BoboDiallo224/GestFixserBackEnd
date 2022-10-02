package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "payment_expense_type")
public class PaymentExpenseType {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id_payment_expense = null;
    private Double amountPayAddExpense = null;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payment_expense_date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_expense")
    private
    Expense expenseInPaymentExpense;

    public PaymentExpenseType() {
    }

    public PaymentExpenseType(Double amountPayAddExpense, Expense expenseInPaymentExpense) {
        this.amountPayAddExpense = amountPayAddExpense;
        this.expenseInPaymentExpense = expenseInPaymentExpense;
    }

    public Long getId_payment_expense() {
        return id_payment_expense;
    }

    public void setId_payment_expense(Long id_payment_expense) {
        this.id_payment_expense = id_payment_expense;
    }

    public Double getAmountPayAddExpense() {
        return amountPayAddExpense;
    }

    public void setAmountPayAddExpense(Double amountPayAddExpense) {
        this.amountPayAddExpense = amountPayAddExpense;
    }

    public Expense getExpenseInPaymentExpense() {
        return expenseInPaymentExpense;
    }

    public void setExpenseInPaymentExpense(Expense expenseInPaymentExpense) {
        this.expenseInPaymentExpense = expenseInPaymentExpense;
    }

    public Date getPayment_expense_date() {
        return payment_expense_date;
    }

    public void setPayment_expense_date(Date payment_expense_date) {
        this.payment_expense_date = payment_expense_date;
    }
}

