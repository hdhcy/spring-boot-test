package com.cun.dao;

import com.cun.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.awt.SunHints;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {

    @Query(value = "select * from  comment where comment_content like CONCAT('%',:comment_content,'%') order by time desc",nativeQuery = true)
    List<Comment> findByComment_contentLike(@Param("comment_content") String comment_content);

    @Query(value = "select * from comment order by time desc",nativeQuery = true)
    List<Comment> findAll();
}
