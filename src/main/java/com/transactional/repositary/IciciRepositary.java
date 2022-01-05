package com.transactional.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transactional.model.Icici;

@Repository
public interface IciciRepositary extends JpaRepository<Icici, Integer>{

}
