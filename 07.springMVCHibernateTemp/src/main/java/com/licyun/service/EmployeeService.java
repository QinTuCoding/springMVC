package com.licyun.service;

/**
 * Created by 李呈云
 * Description:
 * 2016/9/24.
 */
import java.util.List;

import com.licyun.model.Employee;

public interface EmployeeService {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);

    boolean isEmployeeSsnUnique(Integer id, String ssn);

}