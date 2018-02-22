package com.example.controllers.v1;

import com.example.api.v1.model.PersonDTO;
import com.example.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    public static final String BASE_URL = "api/v1/persons";

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }
}
