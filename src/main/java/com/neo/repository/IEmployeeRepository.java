package com.neo.repository;

import com.neo.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


public interface IEmployeeRepository extends MongoRepository<Employee,Integer> {
    Employee findBy_id(ObjectId id);
    void deleteEmployeeBy_id(ObjectId id);
    void removeEmployeeBy_id(ObjectId id);
}
