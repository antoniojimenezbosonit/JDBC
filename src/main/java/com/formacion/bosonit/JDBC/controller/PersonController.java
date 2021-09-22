package com.formacion.bosonit.JDBC.controller;

import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import com.formacion.bosonit.JDBC.model.DTO.PersonOutputDTO;
import com.formacion.bosonit.JDBC.model.Person;
import com.formacion.bosonit.JDBC.service.PersonServicePort;
import com.formacion.bosonit.JDBC.service.PersonServiceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PersonController {

    PersonServicePort personServiceUseCase;

    @GetMapping
    public List<PersonOutputDTO> getAllPerson(){
        List<Person> personList= new ArrayList<>();
        personList = personServiceUseCase.getAllPerson();
        return personList.stream()
                .map( l -> new PersonOutputDTO(l))
                .collect(Collectors.toList());
    }


    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public PersonOutputDTO addPerson(@RequestBody PersonInputDTO p){

        return personServiceUseCase.createPerson(p);
    }

    @GetMapping("{id_person}")
    public PersonOutputDTO getPersonById(@PathVariable Integer id_person) {

        return personServiceUseCase.getPersonByID(id_person);
    }

    @GetMapping("/getForUser/{user}")
    public List<PersonOutputDTO> getPersonByUser(@PathVariable String user){
            return personServiceUseCase.getPersonByUser(user);
    }


    @Transactional(rollbackOn = Exception.class)
    @DeleteMapping("{id}")
    public  String deletePerson(@PathVariable Integer id){

        personServiceUseCase.deletePerson(id);
        return "persona borrada";
    }

    @PutMapping
    @Transactional(rollbackOn = Exception.class)
    public PersonOutputDTO updatePerson(@RequestBody Person p){

           return personServiceUseCase.updatePerson(p);
    }



}
