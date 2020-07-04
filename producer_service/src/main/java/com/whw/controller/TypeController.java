package com.whw.controller;

import com.whw.dao.TypeDao;
import com.whw.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: month5
 * @ClassName TypeController
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 11:18
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class TypeController {
    @Autowired
    TypeDao typeDao;

    @RequestMapping("/type/list")
    public List<Type> list(){
        return typeDao.findAll();
    }
}
