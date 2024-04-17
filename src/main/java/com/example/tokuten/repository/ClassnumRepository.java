package com.example.tokuten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tokuten.model.ClassnumModel;

@Repository
public interface ClassnumRepository extends JpaRepository<ClassnumModel, Long> {
	
}
