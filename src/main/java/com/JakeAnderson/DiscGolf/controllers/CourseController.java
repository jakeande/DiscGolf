package com.JakeAnderson.DiscGolf.controllers;

import com.JakeAnderson.DiscGolf.models.Menu;
import com.JakeAnderson.DiscGolf.models.dao.CourseDao;
import com.JakeAnderson.DiscGolf.models.Course;
import com.JakeAnderson.DiscGolf.models.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private MenuDao menuDao;

    // Request path: /course
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("courses", courseDao.findAll());
        model.addAttribute("title", "My Courses");

        return "course/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCoursesForm(Model model) {
        model.addAttribute("title", "Add Course");
        model.addAttribute(new Course());
        model.addAttribute("menus", menuDao.findAll());
        return "course/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCoursesForm(@ModelAttribute @Valid Course newCourse,
                                        Errors errors, @RequestParam int menuID, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Course");
            model.addAttribute("menus", menuDao.findAll());
            return "course/add";
        }

        Menu cat = menuDao.findOne(menuID);
        newCourse.setMenu(cat);
        courseDao.save(newCourse);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCourseForm(Model model) {
        model.addAttribute("courses", courseDao.findAll());
        model.addAttribute("title", "Remove Course");
        return "course/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCourseForm(@RequestParam int[] ids) {

        for (int id : ids) {
            courseDao.delete(id);
        }

        return "redirect:";
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(Model model, @RequestParam int id) {
        Menu cat = menuDao.findOne(id);
        List<Course> courses = cat.getCourses();
        model.addAttribute("course", courses);
        model.addAttribute("title", "Course in menu: " + cat.getName());
        return "course/index";
    }

}
