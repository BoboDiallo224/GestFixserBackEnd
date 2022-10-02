package com.example.demo.services;

import com.example.demo.entities.Expense;
import com.example.demo.repositories.ExpenseRepository;
import com.example.demo.repositories.FreshExpenseRepository;
import com.example.demo.repositories.PaymentExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final FreshExpenseRepository freshExpenseRepository;
    private final PaymentExpenseRepository paymentExpenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, FreshExpenseRepository freshExpenseRepository,
                          PaymentExpenseRepository paymentExpenseRepository) {
        this.expenseRepository = expenseRepository;
        this.freshExpenseRepository = freshExpenseRepository;
        this.paymentExpenseRepository = paymentExpenseRepository;
    }

    public Expense saveExpense(Expense expense){
        Expense expenseSave = expenseRepository.save(expense);
        System.out.println("--------------------------"+expense.getFreshExpense().size()+"------------------");
        if (!expense.getPaymentExpenseTypes().isEmpty()){

            expenseSave.getPaymentExpenseTypes().forEach(it ->{
                it.setExpenseInPaymentExpense(expenseSave);
                paymentExpenseRepository.save(it);
            });
        }
        if (expenseSave.getFreshExpense().size() > 0){
            expenseSave.getFreshExpense().forEach( it -> {
                it.setExpense(expenseSave);
                freshExpenseRepository.save(it);
            });
        }

        return expenseSave;
    }

    public Optional<Expense> findExpenseById(Long id_expense){
        return expenseRepository.findById(id_expense);
    }

    public List<Expense> getAllExpenses(){
        //return expenseRepository.findAll();
        return expenseRepository.findAllExpenses();
    }

    public List<Expense> findExpenseByCategory(String category){
        return expenseRepository.findByExpense_type(category);
    }

    public List<Expense> findExpenseByCategories(String category){
        return expenseRepository.findByCategories(category);
    }

    public List<String>findExpenseCategories(){
        return expenseRepository.findByExpenseCategories();
    }

    public List<Expense> findExpenseByDate(Date date){
        return expenseRepository.findByExpense_date(date);
    }

    public List<Expense> findExpenseBeetweenTwoDates(String startDate, String endDate){
        return expenseRepository.findExpenseBetweenTwoDates(startDate, endDate);
    }


    //Update
    public Expense updateExpense(Expense newExpense){

        Expense expense = expenseRepository.findById(newExpense.getId_expense()).get();

        expense.setExpense_designation(newExpense.getExpense_designation());
        expense.setExpense_quantity(newExpense.getExpense_quantity());
        expense.setExpense_type(newExpense.getExpense_type());
        expense.setExpense_unit_price(newExpense.getExpense_unit_price());
        //expense.setPaymentExpenseTypes(newExpense.getPaymentExpenseTypes());
        //expense.setExpense_date();

        //Update list fresh
        if (!newExpense.getFreshExpense().isEmpty()){

            newExpense.getFreshExpense().forEach( it -> {
                it.setExpense(expense);
                freshExpenseRepository.save(it);
            });
        }

        //Update payment if Exist
       /* if (!expense.getPaymentExpenseTypes().isEmpty() && !newExpense.getPaymentExpenseTypes().isEmpty()){

            newExpense.getPaymentExpenseTypes().forEach(it ->{
                it.setExpenseInPaymentExpense(expense);
                paymentExpenseRepository.save(it);
            });
        }*/

        return expenseRepository.save(expense);
    }

}
