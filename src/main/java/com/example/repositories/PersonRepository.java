package com.example.repositories;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByLastName(String name);
    Person findById(Long id);
}
