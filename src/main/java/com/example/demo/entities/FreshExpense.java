package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "fresh_expense")
public class FreshExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_fresh_expense = null;
    private int id_forUpdateList;
    private String fresh_expense_designation;
    private Long fresh_expense_amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_expense")
    private
    Expense expense;

    public FreshExpense() {
    }

    public FreshExpense(int id_forUpdateList, String fresh_expense_designation, Long fresh_expense_amount, Expense expense) {
        this.id_forUpdateList = id_forUpdateList;
        this.fresh_expense_designation = fresh_expense_designation;
        this.fresh_expense_amount = fresh_expense_amount;
        this.expense = expense;
    }

    public Long getId_fresh_expense() {
        return id_fresh_expense;
    }

    public void setId_fresh_expense(Long id_fresh_expense) {
        this.id_fresh_expense = id_fresh_expense;
    }

    public int getId_forUpdateList() {
        return id_forUpdateList;
    }

    public void setId_forUpdateList(int id_forUpdateList) {
        this.id_forUpdateList = id_forUpdateList;
    }

    public String getFresh_expense_designation() {
        return fresh_expense_designation;
    }

    public void setFresh_expense_designation(String fresh_expense_designation) {
        this.fresh_expense_designation = fresh_expense_designation;
    }

    public Long getFresh_expense_amount() {
        return fresh_expense_amount;
    }

    public void setFresh_expense_amount(Long fresh_expense_amount) {
        this.fresh_expense_amount = fresh_expense_amount;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
