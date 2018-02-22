package com.example.Bootstrap;


import com.example.domain.Person;
import com.example.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner{

    private final PersonRepository personRepository;

    public Bootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        loadPersons();
    }

    private void loadPersons() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setFirstName("John");
        person1.setLastName("Cena");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Sarah");
        person2.setLastName("Conner");
        personRepository.save(person2);

        Person person3 = new Person();
        person3.setId(3L);
        person3.setFirstName("Testi");
        person3.setLastName("Test");
        personRepository.save(person3);
    }
}
