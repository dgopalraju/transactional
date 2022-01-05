package com.transactional.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transactional.model.Sbi;

@Repository
public interface SbiRepositary extends JpaRepository<Sbi, Integer> {

}
