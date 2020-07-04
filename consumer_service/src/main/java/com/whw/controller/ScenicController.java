package com.whw.controller;

import com.whw.api.ScenicApi;
import com.whw.entity.Scenic;
import com.whw.query.ScenicQuery;
import com.whw.response.Page;
import com.whw.response.ResponseData;
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
    private ScenicApi scenicApi;

    @RequestMapping(path = "/scenic/page",method = RequestMethod.POST)
    public Page<Scenic> page(@RequestBody ScenicQuery query){
        return scenicApi.page(query);
    }
    @RequestMapping(path="/scenic/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam Integer id) {
        return ResponseData.success(scenicApi.findById(id));
    }
    @RequestMapping(path="/scenic/save", method = RequestMethod.POST)
    public ResponseData save(@RequestBody Scenic scenic) {
        return ResponseData.success(scenicApi.save(scenic));
    }
    @RequestMapping(path="/scenic/update", method = RequestMethod.POST)
    public ResponseData update(@RequestBody Scenic scenic) {
        return ResponseData.success(scenicApi.update(scenic));
    }
    @RequestMapping(path="/scenic/delete", method = RequestMethod.GET)
    public ResponseData delete(@RequestParam List<Integer> id) {
        scenicApi.delete(id);
        return ResponseData.success();
    }
}
