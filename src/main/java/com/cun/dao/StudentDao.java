package com.cun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cun.entity.Student;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
