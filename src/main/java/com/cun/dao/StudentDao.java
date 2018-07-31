package com.cun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cun.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
