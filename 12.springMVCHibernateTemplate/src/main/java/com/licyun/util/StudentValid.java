package com.licyun.util;

import com.licyun.model.Student;
import com.licyun.service.StudentService;
import com.licyun.service.imp.StudentServiceImp;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by 李呈云
 * Description:
 * 2016/9/27.
 */
@Component
public class StudentValid implements Validator {
    public boolean supports(Class<?> klass) {
        return Student.class.isAssignableFrom(klass);
    }

    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        ValidationUtils.rejectIfEmpty(errors, "age", "userage.required");
        ValidationUtils.rejectIfEmpty(errors, "name", "username.required");
        ValidationUtils.rejectIfEmpty(errors, "sex", "usersex.required");
        if(student.getAge() > 200){
            errors.rejectValue("age", "userage.error");
        }
        if(student.getName().length() < 2){
            errors.rejectValue("name", "username.error");
        }
    }

}
