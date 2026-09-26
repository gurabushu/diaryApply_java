package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Dyuser;

public interface DyuserRepository extends JpaRepository<Dyuser,Long>{
	
	
}