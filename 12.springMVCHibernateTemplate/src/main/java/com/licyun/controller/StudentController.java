package com.licyun.controller;

import com.licyun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.licyun.dao.StudentDao;
import com.licyun.model.Student;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/find",method={RequestMethod.GET})
    public String find(@Valid int id, Model  model){

        Student student = studentService.findById(id);
        if(student == null){
            return "failed";
        }
        else{
            model.addAttribute("student", student);
            model.addAttribute("msg", "查找成功");
            return "success";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("student", new Student());
        return "register";
    }
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public List<Student> register(Model model , Student student) {
        studentService.saveStudent(student);
        System.out.println(student.getName());
        model.addAttribute("student", student);
        model.addAttribute("msg", "注册成功");
        return studentService.findAllStudent();

    }
}
