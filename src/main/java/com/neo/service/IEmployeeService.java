package com.neo.service;

import com.neo.model.Employee;
import org.bson.types.ObjectId;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findById(ObjectId id);

    void save(Employee employee);

    void remove(ObjectId id);
}
