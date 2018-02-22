package com.example.api.v1.mapper;

import com.example.api.v1.model.PersonDTO;
import com.example.domain.Person;
import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;


@Component
public class PersonConverter{

    @Synchronized
    @Nullable
    public Person convert(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }

        final Person person = new Person();
        person.setId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());

        return person;
    }

    @Synchronized
    @Nullable
    public PersonDTO convert(Person person) {
        if (person == null) {
            return null;
        }

        final PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personDTO.getId());
        personDTO.setFirstName(personDTO.getFirstName());
        personDTO.setLastName(personDTO.getLastName());

        return personDTO;
    }
}
