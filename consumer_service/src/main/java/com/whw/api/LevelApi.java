package com.whw.api;

import com.whw.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient("producer-service")
public interface LevelApi {

    @RequestMapping("/level/list")
    public List<Level> list();
}
