package com.cun.controller;

import com.cun.dao.ArticleDao;
import com.cun.dao.CommentDao;
import com.cun.entity.Article;
import com.cun.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/article")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    //增
    @PostMapping("/insert")
    public Article insertArticle(Article article){
        articleDao.save(article);
        return article;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Article deleteArticle(@PathVariable("id") Integer id){
        Article article=new Article();
        article=articleDao.findOne(id);
        articleDao.delete(id);
        return article;
    }

    //改
    @PutMapping("/update")
    public Article updateArticle(Article article){
        articleDao.save(article);
        return article;
    }

    //查
    @GetMapping("/get/{id}")
    public Article selectArticle(@PathVariable("id") Integer id){
        return articleDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<Article> selectAllArticle(){
        return articleDao.findAll();
    }
}
