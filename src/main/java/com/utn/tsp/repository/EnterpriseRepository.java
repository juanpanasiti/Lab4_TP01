package com.utn.tsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.tsp.entities.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
	
}
