package com.formacion.bosonit.JDBC.controller;

import com.formacion.bosonit.JDBC.model.Person;
import com.formacion.bosonit.JDBC.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> getAllPerson(){
        List<Person> personList= new ArrayList<>();
        personList = personService.getAllPerson();

        return personList;
    }

    @GetMapping("nueva")
    public void newPerson(){
        Person p = new Person();
        p.setUser("antonio");
        p.setPassword("12345");
        p.setName("antonio");
        p.setSurname("jimenez");
        p.setCompany_email("antonio@bosonit.com");
        p.setPersonal_email("antonio@gmail.com");
        p.setCity("Jaen");
        p.setActive(true);
        p.setCreated_date(new Date(2000,01,01 ));
        p.setImagen_url("imagen");
        p.setTermination_date(new Date(2000,01,01));

        personService.createPerson(p);
    }

    @PostMapping()
    public void addPerson(@RequestBody @Valid Person p){

        personService.createPerson(p);
    }

    @GetMapping("{id_person}")
    public Person getPersonById(@PathVariable Integer id_person){
        Person p = new Person();
        p = personService.getPersonByID(id_person);

        return p;
    }

    @GetMapping("/getForUser/{user}")
    public Person getPersonByUser(@PathVariable String user){
        Person p = new Person();
        p = personService.getPersonByUser(user);

        return p;
    }

    @DeleteMapping("{id}")
    public  String deletePerson(@PathVariable Integer id){

        personService.deletePerson(id);
        return "persona borrada";
    }

    @PutMapping
    public Person updatePerson(@RequestBody @Valid Person person){
        personService.updatePerson(person);
        return person;

    }

}
