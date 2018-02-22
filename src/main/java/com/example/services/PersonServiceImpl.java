package com.example.services;

import com.example.api.v1.mapper.PersonConverter;
import com.example.api.v1.model.PersonDTO;
import com.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
//    private final PersonMapper personMapper;
    private final PersonConverter personConverter;

    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(personConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personConverter.convert(personRepository.findById(id));
    }

    @Override
    public PersonDTO getPersonByLastName(String lastName) {
        return personConverter.convert(personRepository.findByLastName(lastName));
    }
}
