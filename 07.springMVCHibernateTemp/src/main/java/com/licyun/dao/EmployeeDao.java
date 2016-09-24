package com.licyun.dao;

/**
 * Created by 李呈云
 * Description:
 * 2016/9/24.
 */
import java.util.List;

import com.licyun.model.Employee;

public interface EmployeeDao {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);

}