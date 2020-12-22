package com.coolway.mapper;

import com.coolway.entity.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudent();

    List<Student> getStudentByNameOrClazz(String nameOrClazz);

}
