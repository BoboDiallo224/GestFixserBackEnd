package com.example.demo.repositories;

import com.example.demo.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

     @Query("select e from expense e order by e.id_expense desc")
     List<Expense> findAllExpenses();

     @Query("select e from expense e where e.expense_type = :y order by e.id_expense desc")
     List<Expense> findByExpense_type(@Param("y") String expenseCategory);

     @Query("select e.expense_type from expense e group by e.expense_type")
     List<String> findByExpenseCategories();

     @Query("select e from expense e where e.expense_type like %:y% order by e.id_expense desc")
     List<Expense> findByCategories(@Param("y") String expenseCategory);

     @Query("select e from expense e where e.expense_date = :date order by e.id_expense desc")
     List<Expense> findByExpense_date(@Param("date")Date date);

     //@Query(value = "select e from expense e where e.expense_date between str_to_date(:firstDate,'%Y-%m-%d') and str_to_date(:secondDate,'%Y-%m-%d')",nativeQuery = true)
     @Query(value = "select * from expense where expense_date between str_to_date(:firstDate,'%Y-%m-%d') and str_to_date(:secondDate,'%Y-%m-%d')",nativeQuery = true)
     List<Expense>findExpenseBetweenTwoDates(@Param("firstDate")String firstDate,@Param("secondDate") String secondDate);
}
