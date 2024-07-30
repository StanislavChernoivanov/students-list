package com.example.students_list.model;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class Student {
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
