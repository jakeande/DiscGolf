package com.JakeAnderson.DiscGolf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2)
    private String name;

    @ManyToMany
    private List<Course> Courses;

    public Menu(){}

    public void addItem(Course item) {Courses.add(item);}

    public int getId() {return id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public List<Course> getCourses() { return Courses; }



}
