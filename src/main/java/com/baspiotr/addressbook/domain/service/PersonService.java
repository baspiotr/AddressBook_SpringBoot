package com.baspiotr.addressbook.domain.service;

import com.baspiotr.addressbook.domain.Person;
import com.baspiotr.addressbook.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void savePerson(Person person) {

        Integer id = person.getId();

        if (id != null) {
            personRepository.delete(id);
            System.out.println("Powinienem usuwac");
        }

        personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }

    public Person getPersonById(Integer id) {
        return personRepository.getOne(id);
    }

    public List<Person> getPersonsByQuery(String query) {
        List<Person> personListByFirstName= personRepository.findByFirstName(query);
        List<Person> personListByLastName= personRepository.findByLastName(query);
        List<Person> personListByHomePhoneNumber= personRepository.findByHomePhoneNumber(query);
        List<Person> personListByWorkPhoneNumber= personRepository.findByWorkPhoneNumber(query);
        List<Person> personListByEmail= personRepository.findByEmail(query);

        Set<Person> personSet = new HashSet<>();

        personSet.addAll(personListByFirstName);
        personSet.addAll(personListByLastName);
        personSet.addAll(personListByHomePhoneNumber);
        personSet.addAll(personListByWorkPhoneNumber);
        personSet.addAll(personListByEmail);

        return personSet.stream().collect(Collectors.toList());
    }

}
