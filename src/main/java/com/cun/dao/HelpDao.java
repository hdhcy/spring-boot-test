package com.cun.dao;

import com.cun.entity.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HelpDao extends JpaRepository<Help,Integer> {

    @Query(value = "select * from help where user_id = CONCAT(:user_id) order by time desc",nativeQuery = true)
    List<Help> findByUser_id(@Param("user_id") String user_id);

    @Query(value = "select * from help where question_content like CONCAT('%',:question_content,'%') order by time desc",nativeQuery = true)
    List<Help> findByQuestion_contentLike(@Param("question_content") String question_content);

    @Query(value = "select * from help order by time desc",nativeQuery = true)
    List<Help> findAll();
}
