package com.formacion.bosonit.JDBC.service;


import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import com.formacion.bosonit.JDBC.model.Person;
import com.formacion.bosonit.JDBC.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public List<Person> getAllPerson(){
        List<Person> p = new ArrayList<>();
        p = personRepository.findAll();
        return p;
    }


    public Person getPersonByID(Integer id){
        Optional<Person> p;
        p = personRepository.findById(id);
        return p.get();
    }

    public Person getPersonByUser(String user){
        Optional<Person> p;
        p = personRepository.findByuser(user);
        return p.get();
    }

    public String createPerson(@Valid Person p){
        personRepository.save(p);
        return "Persona " + p + "guardada";
    }

    public void deletePerson(Integer id){
         personRepository.deleteById(id);
    }

    public Person updatePerson(Person person){
        Person personSaved = getPersonByID(person.getId_person());
        personSaved.setTermination_date(person.getTermination_date());
        personSaved.setPersonal_email(person.getPersonal_email());
        personSaved.setSurname(person.getSurname());
        personSaved.setPassword(person.getPassword());
        personSaved.setName(person.getName());
        personSaved.setUser(person.getUser());
        personSaved.setImagen_url(person.getImagen_url());
        personSaved.setCreated_date(person.getCreated_date());
        personSaved.setCity(person.getCity());
        personSaved.setCompany_email(person.getCompany_email());
        personRepository.save(person);
        return personSaved;
    }
}
