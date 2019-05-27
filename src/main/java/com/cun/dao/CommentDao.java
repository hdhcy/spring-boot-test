package com.cun.dao;

import com.cun.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {
}
