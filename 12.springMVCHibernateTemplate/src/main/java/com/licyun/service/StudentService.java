package com.licyun.service;


import com.licyun.model.Student;

import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/3.
 */
public interface StudentService {

    Student findById(int id);

    Student findByName(String name);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> findAllStudent();



}
