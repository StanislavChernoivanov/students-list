package com.example.students_list.services;

import com.example.students_list.exceptions.StudentNotFoundException;
import com.example.students_list.model.Student;
import com.example.students_list.model.StudentsListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentsListServiceImpl implements StudentsListService{

    private final StudentsListRepository studentsListRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentsListRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentsListRepository.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {
        Student newStudent = findStudentById(student.getId());
        studentsListRepository.editStudent(newStudent);
    }

    @Override
    public void deleteStudent(long id) {
        studentsListRepository.deleteStudent(id);
    }

    @Override
    public Student findStudentById(long id) {
        Optional<Student> student = studentsListRepository.findById(id);
        if(student.isPresent()) return student.get();
        else throw new StudentNotFoundException("Студент с данным id не найден");
    }
}
