package com.example.demo.repositories;

import com.example.demo.entities.Expense;
import com.example.demo.entities.PaymentExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentExpenseRepository extends JpaRepository<PaymentExpenseType, Long> {

    /*@Query("select p from payment_expense_type where rownum <= :number and p.expenseInPaymentExpense.id_expense = :id_expense" +
            " order by p.id_payment_expense desc ")*/
    @Query(value = "select * from payment_expense_type where id_expense = :id  order by id_payment_expense desc LIMIT 5", nativeQuery = true)
    List<PaymentExpenseType> findSomePaymentExpense(@Param("id") Long id_expense);

    @Query(value = "select * from payment_expense_type where id_expense = :id  order by id_payment_expense desc", nativeQuery = true)
    List<PaymentExpenseType>findByExpenseInPaymentExpenseOrderById_payment_expenseDesc(@Param("id") Long id_expense);

}
