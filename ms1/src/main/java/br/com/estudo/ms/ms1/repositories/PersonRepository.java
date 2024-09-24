package br.com.estudo.ms.ms1.repositories;

import br.com.estudo.ms.ms1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
