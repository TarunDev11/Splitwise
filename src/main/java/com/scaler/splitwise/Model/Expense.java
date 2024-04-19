package com.scaler.splitwise.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    private Date createdOn;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<User> member = new ArrayList<>();

    @OneToMany //1 user experience can have multiple users but vice versa not true
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany
    private List<UserExpense> owedBy = new ArrayList<>();

}
