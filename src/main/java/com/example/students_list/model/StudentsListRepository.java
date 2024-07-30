package com.example.students_list.model;

import java.util.List;
import java.util.Optional;

public interface StudentsListRepository {

    List<Student> findAll();

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(long id);

    Optional<Student> findById(long id);
}
