package com.example.demo.controllers;

import com.example.demo.entities.Expense;
import com.example.demo.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create_expense")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        Expense expenseSave = expenseService.saveExpense(expense);
         return ResponseEntity.ok(expenseSave);
    }


    @GetMapping("/find_by_id/{id_expense}")
    public Optional<Expense> getExpenseById(@PathVariable Long id_expense){
        return expenseService.findExpenseById(id_expense);
    }

    @GetMapping("expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("find_by_category/{category}")
    public List<Expense> findByExpenseCategory(@PathVariable String category){
        return expenseService.findExpenseByCategory(category);
    }

    @GetMapping("find_by_categories/{category}")
    public List<Expense> findExpenseByCategories(@PathVariable String category){
        return expenseService.findExpenseByCategories(category);
    }

    @GetMapping("findcategories")
    public List<String> findExpenseCategories(){
        return expenseService.findExpenseCategories();
    }

    @GetMapping("find_by_date/{date}")
    public List<Expense> findExpenseByDate(@PathVariable String date){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return expenseService.findExpenseByDate(date1);
    }

    @GetMapping("find_between_dates/{startDate}/{endDate}")
    public List<Expense> findExpenseBetweenTwoDates(@PathVariable String startDate, @PathVariable String endDate){
        return expenseService.findExpenseBeetweenTwoDates(startDate,endDate);
    }

    //Update Expense
    @PutMapping("update_expense")
    public Expense updateExpense(@RequestBody Expense expense){
        return expenseService.updateExpense(expense);
    }
}
