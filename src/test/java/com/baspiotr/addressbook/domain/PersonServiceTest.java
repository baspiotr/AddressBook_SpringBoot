package com.baspiotr.addressbook.domain;

import com.baspiotr.addressbook.domain.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void savePersonTest() {

        Person p = Person.builder().firstName("Piotr").lastName("Bas").email("piotr@piotr.pl").homePhoneNumber("123123123").workPhoneNumber("234234234").build();

        personService.savePerson(p);

        for (Person person:personService.getAllPersons()) {
            if (person.getFirstName().equals("Piotr")){
                assertTrue(true);
                break;
            }
        }
    }


    @Test
    public void getPersonByQueryTest() {

        Person p1 = Person.builder().firstName("Piotr").lastName("Bas").email("piotr@piotr.pl").homePhoneNumber("123123123").workPhoneNumber("234234234").build();
        Person p2 = Person.builder().firstName("Kuba").lastName("Kowalski").email("kuba@kuba.pl").homePhoneNumber("567567567").workPhoneNumber("345345345").build();
        Person p3 = Person.builder().firstName("Mateusz").lastName("Gryn").email("gryn@gryn.pl").homePhoneNumber("543634535").workPhoneNumber("694839383").build();

        personService.savePerson(p1);
        personService.savePerson(p2);
        personService.savePerson(p3);

        String query = "Kowalski";

        List<Person> persons = personService.getPersonsByQuery(query);

        Person foundPerson = persons.get(0);

        assertEquals("kuba@kuba.pl",foundPerson.getEmail());
    }

}
