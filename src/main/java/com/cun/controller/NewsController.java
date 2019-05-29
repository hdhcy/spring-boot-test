package com.cun.controller;

import com.cun.dao.NewsDao;
import com.cun.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class NewsController {

    @Autowired
    private NewsDao newsDao;

    //增
    @PostMapping("/insert")
    public News insertNews(News news){

        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setTime(dateFormat.format(date));
        newsDao.save(news);
        return news;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public News deleteNews(@PathVariable("id") Integer id){
        News news=new News();
        news=newsDao.findOne(id);
        newsDao.delete(id);
        return news;
    }

    //改
    @PutMapping("/update")
    public News updateNews(News news){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setTime(dateFormat.format(date));
        newsDao.save(news);
        return news;
    }

    //查
    @GetMapping("/get/{id}")
    public News selectNews(@PathVariable("id") Integer id){
        return newsDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<News> selectAllNews(){
        return newsDao.findAll();
    }

    //查标题
    @GetMapping("/title/{news_title}")
    public List<News> selectNewsByTitle(@PathVariable("news_title") String news_title){
        return newsDao.findByNews_titleLike(news_title);
    }

    //查内容
    @GetMapping("/content/{news_content}")
    public List<News> selectNewsByContent(@PathVariable("news_content") String news_content){
        return newsDao.findByNews_contentLike(news_content);
    }

    //通过user_id查找
    @GetMapping("/user/{user_id}")
    public List<News> selectNewsByUser_ido(@PathVariable("user_id") String user_id) {
        return newsDao.findByUser_id(user_id);
    }

    //通过page_number查找
    @GetMapping("/page/{page_number}")
    public List<News> selectNewsByPage_number(@PathVariable("page_number") Integer page_number){
        return newsDao.findByPage_number(page_number);
    }
}
