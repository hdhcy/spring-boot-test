package com.cun.dao;

import com.cun.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsDao extends JpaRepository<News,Integer> {

    @Query(value = "select * from news where user_id = CONCAT(:user_id) order by time desc",nativeQuery = true)
    List<News> findByUser_id(@Param("user_id") String user_id);

    @Query(value = "select * from news where news_title like CONCAT('%',:news_title,'%') order by time desc",nativeQuery = true)
    List<News> findByNews_titleLike(@Param("news_title") String news_title);

    @Query(value = "select * from news where news_content like CONCAT('%',:news_content,'%') order by time desc",nativeQuery = true)
    List<News> findByNews_contentLike(@Param("news_content") String news_content);

    @Query(value = "select * from news order by time desc",nativeQuery = true)
    List<News> findAll();

    @Query(value = "select * from news where page_number = CONCAT(:page_number) order by time desc",nativeQuery = true)
    List<News> findByPage_number(@Param("page_number") Integer page_number);
}
