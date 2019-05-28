package com.cun.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String user_id;

    @Column
    private Integer comment_id;

    @Column
    private String user_image_url;

    @Column
    private String user_nick_name;

    @Column
    private String time;

    @Column(length = 50)
    private String question_title;

    @Column(length = 200)
    private String question_content;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getUser_nick_name() {
        return user_nick_name;
    }

    public void setUser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }
}
