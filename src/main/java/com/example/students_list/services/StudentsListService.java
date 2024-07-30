package com.example.students_list.services;

import com.example.students_list.model.Student;

import java.util.List;

public interface StudentsListService {


    List<Student> findAllStudents();


    void addStudent(Student student);


    void editStudent(Student Student);

    void deleteStudent(long id);

    Student findStudentById(long id);
}
