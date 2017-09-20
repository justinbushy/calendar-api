package com.example.calendarapi.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

    User findByEmail(String email);

    User findByFirstNameAndLastName(String firstName, String lastName);

    User findByUserName(String userName);

    User findById(long id);
}
