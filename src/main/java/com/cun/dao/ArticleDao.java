package com.cun.dao;

import com.cun.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Integer> {
}
