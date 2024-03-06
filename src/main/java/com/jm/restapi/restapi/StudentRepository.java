package com.jm.restapi.restapi;

import com.jm.restapi.restapi.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
