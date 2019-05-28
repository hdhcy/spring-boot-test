package com.cun.controller;

import com.cun.dao.QuestionDao;
import com.cun.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/question")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class QuestionController {

    @Autowired
    private QuestionDao questionDao;

    //增
    @PostMapping("/insert")
    public Question insertQuestion(Question question){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        question.setTime(dateFormat.format(date));
        questionDao.save(question);
        return question;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Question deleteQuestion(@PathVariable("id") Integer id){
        Question question=new Question();
        question=questionDao.findOne(id);
        questionDao.delete(id);
        return question;
    }

    //改
    @PutMapping("/update")
    public Question updateQuestion(Question question){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        question.setTime(dateFormat.format(date));
        questionDao.save(question);
        return question;
    }

    //查
    @GetMapping("/get/{id}")
    public Question selectQuestion(@PathVariable("id") Integer id){
        return questionDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<Question> selectAllQuestion(){
        return questionDao.findAll();
    }

    //查标题
    @GetMapping("/title/{question_title}")
    public List<Question> selectQuestionByTitle(@PathVariable("question_title") String question_title){
        return questionDao.findByQuestion_titleLike(question_title);
    }

    //查内容
    @GetMapping("/content/{question_content}")
    public List<Question> selectQuestionByContent(@PathVariable("question_content") String question_content){
        return questionDao.findByQuestion_contentLike(question_content);
    }

    //通过user_id查找
    @GetMapping("/user/{user_id}")
    public List<Question> selectQuestionByUser_id(@PathVariable("user_id") String user_id) {
        return questionDao.findByUser_id(user_id);
    }
}
