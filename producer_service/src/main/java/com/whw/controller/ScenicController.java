package com.whw.controller;

import com.whw.entity.Scenic;
import com.whw.query.ScenicQuery;
import com.whw.response.Page;
import com.whw.response.ResponseData;
import com.whw.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: month5
 * @ClassName ScenicController
 * @description:
 * @author: 吴宏伟
 * @create: 2020-03-17 09:43
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class ScenicController {

    @Autowired
    private ScenicService scenicService;

    @RequestMapping(path = "/scenic/page",method = RequestMethod.POST)
    public Page<Scenic> page(@RequestBody ScenicQuery query){
        return scenicService.page(query);
    }
    @RequestMapping(path="/scenic/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam Integer id) {
        return ResponseData.success(scenicService.findById(id));
    }
    @RequestMapping(path="/scenic/save", method = RequestMethod.POST)
    public ResponseData save(@RequestBody Scenic scenic) {
        return ResponseData.success(scenicService.save(scenic));
    }
    @RequestMapping(path="/scenic/update", method = RequestMethod.POST)
    public ResponseData update(@RequestBody Scenic scenic) {
        return ResponseData.success(scenicService.update(scenic));
    }
    @RequestMapping(path="/scenic/delete", method = RequestMethod.GET)
    public ResponseData delete(@RequestParam List<Integer> id) {
        scenicService.deleteAll(id);
        return ResponseData.success();
    }
}
