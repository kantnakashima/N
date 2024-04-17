package com.example.tokuten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tokuten.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	
}
