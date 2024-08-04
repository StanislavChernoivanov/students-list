package com.example.students_list.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setFirstName(rs.getString(Student.Fields.firstName));
        student.setLastName(rs.getString(Student.Fields.lastName));
        student.setEmail(rs.getString(Student.Fields.email));
        student.setPhone(rs.getString(Student.Fields.phone));
        student.setId(rs.getLong(Student.Fields.id));
        return student;
    }
}
