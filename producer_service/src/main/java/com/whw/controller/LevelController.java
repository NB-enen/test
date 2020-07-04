package com.whw.controller;

import com.whw.dao.LevelDao;
import com.whw.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: month5
 * @ClassName LevelController
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 11:17
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class LevelController {

    @Autowired
    LevelDao levelDao;

    @RequestMapping("/level/list")
    public List<Level> list(){
        return levelDao.findAll();
    }
}
