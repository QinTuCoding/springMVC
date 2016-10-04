package com.licyun.dao;
import com.licyun.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {

    Student findById(int id);

    Student findByName(String name);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> findAllStudent();

}
