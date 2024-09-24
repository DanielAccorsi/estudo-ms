package br.com.estudo.ms.ms1.services;

import br.com.estudo.ms.ms1.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private  final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people.");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAdress("Address " + i);
        person.setGender("Male");
        return person;
    }

    public Person findBytId(String id) {
        logger.info("Finding person.");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Daniel");
        person.setLastName("Accorsi");
        person.setAdress("Londrina PR");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating Person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating Person!");
        return person;
    }

    public void  delete(String id) {
        logger.info("Deleting Person!");
    }

}
