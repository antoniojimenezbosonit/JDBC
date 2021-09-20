package com.formacion.bosonit.JDBC.model.DTO;

import com.formacion.bosonit.JDBC.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
public class PersonOutputDTO {

    String name;
    String surname;
    String mail;

    public PersonOutputDTO(Person person){

        this.name = person.getName();
        this.surname = person.getSurname();
        this.mail = person.getCompany_email();
    }

    public PersonOutputDTO(PersonInputDTO person){

        this.name = person.getName();
        this.surname = person.getSurname();
        this.mail = person.getCompany_email();
    }
}
