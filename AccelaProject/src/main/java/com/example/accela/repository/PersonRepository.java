package com.example.accela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accela.model.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{

}
