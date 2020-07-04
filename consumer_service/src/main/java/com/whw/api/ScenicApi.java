package com.whw.api;

import com.whw.entity.Scenic;
import com.whw.query.ScenicQuery;
import com.whw.response.Page;
import com.whw.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient("producer-service")
public interface ScenicApi {

    @RequestMapping(path = "/scenic/page",method = RequestMethod.POST)
    public Page<Scenic> page(@RequestBody ScenicQuery scenicQuery);

    @RequestMapping(path="/scenic/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam Integer id);

    @RequestMapping(path="/scenic/save", method = RequestMethod.POST)
    public ResponseData save(@RequestBody Scenic scenic);

    @RequestMapping(path="/scenic/update", method = RequestMethod.POST)
    public ResponseData update(@RequestBody Scenic scenic);

    @RequestMapping(path="/scenic/delete", method = RequestMethod.GET)
    public ResponseData delete(@RequestParam List<Integer> id);
}
