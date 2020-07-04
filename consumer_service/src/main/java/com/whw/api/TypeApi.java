package com.whw.api;


import com.whw.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: month5
 * @ClassName TypeController
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 11:18
 * @Version 1.0
 **/
@FeignClient("producer-service")
public interface TypeApi {

    @RequestMapping("/type/list")
    public List<Type> list();
}
