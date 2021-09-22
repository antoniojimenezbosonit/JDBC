package com.formacion.bosonit.JDBC.service;

import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import com.formacion.bosonit.JDBC.model.DTO.PersonOutputDTO;
import com.formacion.bosonit.JDBC.model.Person;
import java.util.List;

public interface PersonServicePort {

    List<Person> getAllPerson();
    PersonOutputDTO getPersonByID(Integer id);
    List<PersonOutputDTO> getPersonByUser(String user);
    PersonOutputDTO createPerson(PersonInputDTO p);
    void deletePerson(Integer id);
    PersonOutputDTO updatePerson(Integer id, PersonInputDTO person);
    void validation(Person person);
}
