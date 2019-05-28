package com.cun.controller;

import com.cun.dao.HelpDao;
import com.cun.entity.Help;
import com.cun.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/help")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class HelpController {

    @Autowired
    private HelpDao helpDao;

    //增
    @PostMapping("/insert")
    public Help insertHelp(Help help){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        help.setTime(dateFormat.format(date));
        helpDao.save(help);
        return help;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Help deleteHelp(@PathVariable("id") Integer id){
        Help help=new Help();
        help=helpDao.findOne(id);
        helpDao.delete(id);
        return help;
    }

    //改
    @PutMapping("/update")
    public Help updateHelp(Help help){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        help.setTime(dateFormat.format(date));
        helpDao.save(help);
        return help;
    }

    //查
    @GetMapping("/get/{id}")
    public Help selectHelp(@PathVariable("id") Integer id){
        return helpDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<Help> selectAllHelp(){
        return helpDao.findAll();
    }

    //查内容
    @GetMapping("/content/{question_content}")
    public List<Help> selectHelpByContent(@PathVariable("question_content") String question_content){
        return helpDao.findByQuestion_contentLike(question_content);
    }

    //通过user_id查找
    @GetMapping("/user/{user_id}")
    public List<Help> selectHelpByUser_ido(@PathVariable("user_id") String user_id) {
        return helpDao.findByUser_id(user_id);
    }
}
