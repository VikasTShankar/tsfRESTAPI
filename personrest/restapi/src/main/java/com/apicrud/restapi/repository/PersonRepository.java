package com.apicrud.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apicrud.restapi.model.Person;

import java.util.List;
@Repository
public interface PersonRepository extends MongoRepository<Person,String>{
    public List<Person> findByAge(int age);
    public Person findByFirstName(String firstName);
    public Person findByLastName(String lastName);
}
