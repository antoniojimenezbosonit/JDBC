package com.formacion.bosonit.JDBC.controller;

import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import com.formacion.bosonit.JDBC.model.DTO.PersonOutputDTO;
import com.formacion.bosonit.JDBC.model.Person;
import com.formacion.bosonit.JDBC.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
        personService.createPerson(person);
        PersonOutputDTO personDTO = new PersonOutputDTO(p);
        return personDTO;

    }

    @GetMapping("{id_person}")
    public PersonOutputDTO getPersonById(@PathVariable Integer id_person){
        Person p = new Person();
        p = personService.getPersonByID(id_person);
        PersonOutputDTO personDTO = new PersonOutputDTO(p);
        return personDTO;
    }

    @GetMapping("/getForUser/{user}")
    public PersonOutputDTO getPersonByUser(@PathVariable String user){
        Person p = new Person();
        p = personService.getPersonByUser(user);
        PersonOutputDTO personDTO = new PersonOutputDTO(p);

        return personDTO;
    }
    @Transactional(rollbackOn = Exception.class)
    @DeleteMapping("{id}")
    public  String deletePerson(@PathVariable Integer id){

        personService.deletePerson(id);
        return "persona borrada";
    }

    @PutMapping
    @Transactional(rollbackOn = Exception.class)
    public PersonOutputDTO updatePerson(@RequestBody @Valid PersonInputDTO p){
        Person person = new Person(p);
        personService.updatePerson(person);
        PersonOutputDTO personDTO = new PersonOutputDTO(p);
        return personDTO;

    }

}
