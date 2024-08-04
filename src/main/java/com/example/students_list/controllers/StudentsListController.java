package com.example.students_list.controllers;
import com.example.students_list.model.Student;
import com.example.students_list.services.StudentsListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentsListController {

    private final StudentsListService studentsListService;
    @GetMapping("/")
    public String index(Model model) {
        List<Student> students = studentsListService.findAllStudents();
        model.addAttribute("students", students);
        return "index";
    }
    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute Student student) {
        studentsListService.addStudent(student);
        return "redirect:/";
    }
    @PostMapping("/student/edit/{id}")
    public String editStudent(@ModelAttribute Student student, @PathVariable Long id) {
        studentsListService.editStudent(id, student);
        return "redirect:/";
    }
    @GetMapping("/student/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("formName", "Add student");
        model.addAttribute("action", "/student/add");
        model.addAttribute("submit", "Add");
        return "addEdit";
    }


    @GetMapping("/student/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentsListService.findStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("formName", "Edit student");
        model.addAttribute("action", "/student/edit/" + id);
        model.addAttribute("submit", "Edit");
        return "addEdit";
    }


    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentsListService.deleteStudent(id);
        return "redirect:/";
    }


 }
