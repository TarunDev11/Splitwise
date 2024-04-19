package com.scaler.splitwise.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="expense_groups")
public class Group extends BaseModel{
    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();
}
