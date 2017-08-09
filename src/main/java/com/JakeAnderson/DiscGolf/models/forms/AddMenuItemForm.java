package com.JakeAnderson.DiscGolf.models.forms;

import com.JakeAnderson.DiscGolf.models.Course;
import com.JakeAnderson.DiscGolf.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int courseId;

    private Iterable<Course> courses;

    private Menu menu;

    public AddMenuItemForm() {}

    public AddMenuItemForm(Iterable<Course> courses, Menu menu){
        this.courses = courses;
        this.menu = menu;
    }
    public int getMenuId() { return menuId; }

    public void setMenuId(int menuId) { this.menuId = menuId;}

    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {this.courseId = courseId;}

    public Iterable<Course> getCourses() {return courses; }

    public Menu getMenu(){
        return menu;
    }
}
