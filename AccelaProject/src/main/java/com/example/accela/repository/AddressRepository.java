package com.example.accela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accela.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository <Address, Long>{

}
