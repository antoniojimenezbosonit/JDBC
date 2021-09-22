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
        setPerson(p);
    }

    public void setPerson(PersonInputDTO p){
        if(p == null)
            return ;
        if(p.getUser() != null) this.user = p.getUser();
        if(p.getPassword() != null) this.password = p.getPassword();
        if(p.getName() != null) this.name = p.getName();
        if(p.getSurname() != null) this.surname = p.getSurname();
        if(p.getCompany_email() != null) this.company_email = p.getCompany_email();
        if(p.getPersonal_email() != null) this.personal_email = p.getPersonal_email();
        if(p.getCity() != null) this.city = p.getCity();
        if(p.getActive() != null) this.active = p.getActive();
        if(p.getCreated_date() != null) this.created_date = p.getCreated_date();
        if(p.getImagen_url() != null) this.imagen_url = p.getImagen_url();
        if(p.getTermination_date() != null) this.termination_date = p.getTermination_date();
    }

}
