package com.formacion.bosonit.JDBC.model;


import com.formacion.bosonit.JDBC.model.DTO.PersonInputDTO;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    Integer id_person;
    @Column(nullable = false)
    @Size(min  = 6, max = 10)
    String user;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String surname;
    @Column(nullable = false)
    @Email
    String company_email;
    @Column(nullable = false)
    @Email
    String personal_email;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    Boolean active;
    @Column(nullable = false)
    Date created_date;
    String imagen_url;
    Date termination_date;

    public Person(PersonInputDTO p){
        this.user = p.getUser();
        this.password = p.getPassword();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.company_email = p.getCompany_email();
        this.personal_email = p.getPersonal_email();
        this.city = p.getCity();
        this.active = p.getActive();
        this.created_date = p.getCreated_date();
        this.imagen_url = p.getImagen_url();
        this.termination_date = p.getTermination_date();
    }

}
