package com.cun.entity;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer user_id;

    @Column(length = 50)
    private String article_title;

    @Column(length = 100)
    private String article_image_url;

    @Column(length = 200)
    private String article_content;

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_image_url() {
        return article_image_url;
    }

    public void setArticle_image_url(String article_image_url) {
        this.article_image_url = article_image_url;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }
}
