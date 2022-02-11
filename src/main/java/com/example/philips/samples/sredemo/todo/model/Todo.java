package com.example.philips.samples.sredemo.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull()
    @NotEmpty()
    public String title;


    public String description;
}
