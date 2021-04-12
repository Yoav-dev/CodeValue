package com.devskiller.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Authors extends JpaRepository<Author, Integer>{

}