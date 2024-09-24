package br.com.estudo.ms.ms1.services;

import br.com.estudo.ms.ms1.exceptions.ResourceNotFoundException;
import br.com.estudo.ms.ms1.model.Person;
import br.com.estudo.ms.ms1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people.");

        return repository.findAll();
    }

    public Person findBytId(Long id) {
        logger.info("Finding person.");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating Person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating Person!");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void  delete(Long id) {
        logger.info("Deleting Person!");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
