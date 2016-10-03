package com.mark.java.DAO;

import com.mark.java.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mark on 4/24/15.
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int save(User u) {
        return (Integer) sessionFactory.getCurrentSession().save(u);
    }

    public List<User> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
}
