package com.licyun.dao.imp;

import com.licyun.dao.StudentDao;
import com.licyun.model.Student;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("StudentDao")
public class StudentDaoImp extends BaseDaoImp<Student> implements StudentDao {

    public Student findById(int id){
        return get(Student.class, id);
    }

    public Student findByName(String name){
        return find("from Student where name = ?", name);
    }

    public void saveStudent(Student student){
        save(student);
    }

    public void updateStudent(Student student){
        update(student);
    }

    public void deleteStudent(Student student){
        delete(student);
    }

    public List<Student> findAllStudent(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
        return (List<Student>) getHibernateTemplate().findByCriteria(criteria);
    }
}
