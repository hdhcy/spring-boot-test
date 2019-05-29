package com.cun.dao;

import com.cun.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    @Query(value = "select * from  question where user_id = CONCAT(:user_id) order by time desc",nativeQuery = true)
    List<Question> findByUser_id(@Param("user_id") String user_id);

    @Query(value = "select * from  question where question_title like CONCAT('%',:question_title,'%') order by time desc",nativeQuery = true)
    List<Question> findByQuestion_titleLike(@Param("question_title") String question_title);

    @Query(value = "select * from  question where question_content like CONCAT('%',:question_content,'%') order by time desc",nativeQuery = true)
    List<Question> findByQuestion_contentLike(@Param("question_content") String question_content);

    @Query(value = "select * from question order by time desc",nativeQuery = true)
    List<Question> findAll();
}
