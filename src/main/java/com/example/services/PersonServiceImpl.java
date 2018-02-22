package com.example.services;

import com.example.api.v1.mapper.PersonMapper;
import com.example.api.v1.model.PersonDTO;
import com.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
//    private final PersonConverter personConverter;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::personToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personMapper.personToPersonDTO(personRepository.findById(id));
    }

    @Override
    public PersonDTO getPersonByLastName(String lastName) {
        return personMapper.personToPersonDTO(personRepository.findByLastName(lastName));
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.delete(id);
    }
}
