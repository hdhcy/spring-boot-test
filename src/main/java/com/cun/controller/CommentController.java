package com.cun.controller;

import com.cun.dao.CommentDao;
import com.cun.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/comment")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    //增
    @PostMapping("/insert")
    public Comment insertComment(Comment comment){
        commentDao.save(comment);
        return comment;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Comment deleteComment(@PathVariable("id") Integer id){
        Comment comment=new Comment();
        comment=commentDao.findOne(id);
        commentDao.delete(id);
        return comment;
    }

    //改
    @PutMapping("/update")
    public Comment updateComment(Comment comment){
        commentDao.save(comment);
        return comment;
    }

    //查
    @GetMapping("/get/{id}")
    public Comment selectComment(@PathVariable("id") Integer id){
        return commentDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<Comment> selectAllComment(){
        return commentDao.findAll();
    }
}
