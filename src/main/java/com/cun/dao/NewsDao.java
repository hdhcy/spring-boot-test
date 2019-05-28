package com.cun.dao;

import com.cun.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsDao extends JpaRepository<News,Integer> {

    @Query(value = "select * from news where user_id = CONCAT(:user_id)",nativeQuery = true)
    List<News> findByUser_id(@Param("user_id") String user_id);

    @Query(value = "select * from news where news_title like CONCAT('%',:news_title,'%') ",nativeQuery = true)
    List<News> findByNews_titleLike(@Param("news_title") String news_title);

    @Query(value = "select * from news where news_content like CONCAT('%',:news_content,'%') ",nativeQuery = true)
    List<News> findByNews_contentLike(@Param("news_content") String news_content);
}
