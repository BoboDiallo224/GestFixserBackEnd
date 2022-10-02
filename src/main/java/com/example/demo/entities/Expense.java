package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_expense = null;
    private String expense_designation;
    private int expense_quantity;
    private Double expense_unit_price;
    private String expense_type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expense_date;

    @JsonManagedReference
    @OneToMany(mappedBy = "expense")
    private List<FreshExpense> freshExpense;

    @JsonManagedReference
    @OneToMany(mappedBy = "expenseInPaymentExpense")
    private List<PaymentExpenseType> paymentExpenseTypes;

    public Expense() {
    }

    public Expense(List<PaymentExpenseType> paymentExpenseTypes) {
        this.paymentExpenseTypes = paymentExpenseTypes;
    }

    public Long getId_expense() {
        return id_expense;
    }

    public void setId_expense(Long id_expense) {
        this.id_expense = id_expense;
    }

    public String getExpense_designation() {
        return expense_designation;
    }

    public void setExpense_designation(String expense_designation) {
        this.expense_designation = expense_designation;
    }

    public int getExpense_quantity() {
        return expense_quantity;
    }

    public void setExpense_quantity(int expense_quantity) {
        this.expense_quantity = expense_quantity;
    }

    public Double getExpense_unit_price() {
        return expense_unit_price;
    }

    public void setExpense_unit_price(Double expense_unit_price) {
        this.expense_unit_price = expense_unit_price;
    }

    public String getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(String expense_type) {
        this.expense_type = expense_type;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
    }

    public List<FreshExpense> getFreshExpense() {
        return freshExpense;
    }

    public void setFreshExpense(List<FreshExpense> freshExpense) {
        this.freshExpense = freshExpense;
    }

    public List<PaymentExpenseType> getPaymentExpenseTypes() {
        return paymentExpenseTypes;
    }

    public void setPaymentExpenseTypes(List<PaymentExpenseType> paymentExpenseTypes) {
        this.paymentExpenseTypes = paymentExpenseTypes;
    }

    public Expense(String expense_designation, int expense_quantity, Double expense_unit_price,
                   String expense_type, Date expense_date, List<FreshExpense> freshExpense, List<PaymentExpenseType> paymentExpenseTypes) {
        this.expense_designation = expense_designation;
        this.expense_quantity = expense_quantity;
        this.expense_unit_price = expense_unit_price;
        this.expense_type = expense_type;
        this.expense_date = expense_date;
        this.freshExpense = freshExpense;
        this.paymentExpenseTypes = paymentExpenseTypes;
    }
}
