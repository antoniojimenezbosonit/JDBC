package com.formacion.bosonit.JDBC.repository;

import com.formacion.bosonit.JDBC.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Optional<Person>> findByUser(String user);
}
