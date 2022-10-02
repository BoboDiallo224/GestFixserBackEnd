package com.example.demo.repositories;

import com.example.demo.entities.FreshExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreshExpenseRepository extends JpaRepository<FreshExpense, Long> {
}
