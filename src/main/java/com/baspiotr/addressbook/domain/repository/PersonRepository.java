package com.baspiotr.addressbook.domain.repository;

import com.baspiotr.addressbook.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
    List<Person> findByHomePhoneNumber(String homeNumber);
    List<Person> findByWorkPhoneNumber(String workNumber);
    List<Person> findByEmail(String email);
}
