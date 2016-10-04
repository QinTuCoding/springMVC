package com.licyun.service.imp;

import com.licyun.dao.StudentDao;
import com.licyun.model.Student;
import com.licyun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/3.
 */
@Service
@Transactional
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentDao studentDao;

    public Student findById(int id){
        return studentDao.findById(id);
    }

    public Student findByName(String name){
        return  studentDao.findByName(name);
    }

    public void saveStudent(Student student){
        studentDao.saveStudent(student);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);
    }

    public void deleteStudent(Student student){
        studentDao.deleteStudent(student);
    }

    public List<Student> findAllStudent(){
        return studentDao.findAllStudent();
    }


}
