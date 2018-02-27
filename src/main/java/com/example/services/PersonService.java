package com.example.services;

import com.example.api.v1.model.PersonDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO getPersonByLastName(String lastName);

    void deletePersonById(Long id);

    PersonDTO savePersonByDTO(Long id, PersonDTO personDTO);

    PersonDTO createNewPerson(PersonDTO personDTO);
}
