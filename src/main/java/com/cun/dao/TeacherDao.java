package com.cun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cun.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer>{

}
