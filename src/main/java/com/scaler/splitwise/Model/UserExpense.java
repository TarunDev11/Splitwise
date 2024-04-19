package com.scaler.splitwise.Model;

import com.scaler.splitwise.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.function.DoubleToIntFunction;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{

    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private Double Amount;
    @Enumerated
    private ExpenseType expenseType;
}
