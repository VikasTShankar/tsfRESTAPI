package com.crudapi.emprest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crudapi.emprest.model.Emp;
@Repository
public interface EmpRepository extends MongoRepository<Emp,String>{
    public List<Emp> findByAge(int age);
    public Emp findByFirstName(String firstName);
    public Emp findByLastName(String lastName);
}
