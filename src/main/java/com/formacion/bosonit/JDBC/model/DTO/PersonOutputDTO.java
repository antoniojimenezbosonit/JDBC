package com.formacion.bosonit.JDBC.model.DTO;

import com.formacion.bosonit.JDBC.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.Date;


@Data
@NoArgsConstructor
public class PersonOutputDTO {

    Integer id_person;
    String name;
    String surname;
    String user;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date = Date.from(Instant.now());
    Date termination_date;
    String imagen_url;

    public PersonOutputDTO(Person person){

        this.id_person = person.getId_person();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.user = person.getUser();
        this.password = person.getPassword();
        this.company_email = person.getCompany_email();
        this.personal_email = person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.termination_date = person.getTermination_date();
        this.imagen_url = person.getImagen_url();

    }


}
