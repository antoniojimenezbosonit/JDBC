package com.formacion.bosonit.JDBC.controller;

import com.formacion.bosonit.JDBC.exceptions.NotFoundException;
import com.formacion.bosonit.JDBC.exceptions.UnprocesableException;
import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import com.formacion.bosonit.JDBC.model.DTO.PersonOutputDTO;
import com.formacion.bosonit.JDBC.model.Person;
import com.formacion.bosonit.JDBC.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PersonController {

    PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping()
    public List<PersonOutputDTO> getAllPerson(){
        List<Person> personList= new ArrayList<>();
        personList = personService.getAllPerson();
        List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();
        personList.stream().forEach((l) -> {
            PersonOutputDTO pDTP = new PersonOutputDTO(l);
            personOutputDTOList.add(pDTP);
        });
        return personOutputDTOList;
    }


    @PostMapping()
    @Transactional(rollbackOn = Exception.class)
    public PersonOutputDTO addPerson(@RequestBody @Valid PersonInputDTO p){

        Person person = new Person(p);
        validation(person);
        personService.createPerson(person);
        PersonOutputDTO personDTO = new PersonOutputDTO(p);
        return personDTO;

    }

    @GetMapping(value = "{id_person}")
    public PersonOutputDTO getPersonById(@PathVariable Integer id_person) {

        Person p = null;

        try {
            p = personService.getPersonByID(id_person);
        }catch (NoSuchElementException e){
            throw new NotFoundException("error");
        }

        PersonOutputDTO personDTO = new PersonOutputDTO(p);

        return personDTO;
    }

    @GetMapping("/getForUser/{user}")
    public PersonOutputDTO getPersonByUser(@PathVariable String user){
        Person p = new Person();
        try {
            p = personService.getPersonByUser(user);
        }catch (NoSuchElementException e){
            throw new NotFoundException("error");
        }
        PersonOutputDTO personDTO = new PersonOutputDTO(p);

        return personDTO;
    }
    @Transactional(rollbackOn = Exception.class)
    @DeleteMapping("{id}")
    public  String deletePerson(@PathVariable Integer id){
        try {
            personService.deletePerson(id);
        }catch (NoSuchElementException e){
            throw new NotFoundException("error");
        }
        return "persona borrada";
    }

    @PutMapping
    @Transactional(rollbackOn = Exception.class)
    public PersonOutputDTO updatePerson(@RequestBody @Valid PersonInputDTO p){
        Person person = new Person(p);
        try{
            validation(person);
            personService.updatePerson(person);

        }catch (NoSuchElementException e){
            throw new NotFoundException("error");
        }

        PersonOutputDTO personDTO = new PersonOutputDTO(p);
        return personDTO;

    }

    public void validation(Person person) throws  UnprocesableException{
        if(person.getActive() == null) throw new UnprocesableException("active is null");
        if(person.getName() == null) throw new UnprocesableException("name is null");
        if(person.getPersonal_email() == null) throw new UnprocesableException("personal email is null");
        if(person.getCompany_email() == null) throw new UnprocesableException("company email is null");
        if(person.getSurname() == null) throw new UnprocesableException("surname is null");
        if(person.getCity() == null) throw new UnprocesableException("city is null");
        if(person.getImagen_url() == null) throw new UnprocesableException("imagen is null");
        if(person.getPassword() == null) throw new UnprocesableException("password is null");
        if(person.getTermination_date() == null) throw new UnprocesableException("termination date is null");
        if(person.getUser() == null) throw new UnprocesableException("user is null");
        if(person.getCreated_date()== null) throw new UnprocesableException("created date is null");
    }

}
