package com.example.controller;

import com.example.constant.MessageConstant;
import com.example.entity.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import com.example.pojo.TravelItem;
import com.example.service.TravelItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// @Controller +　@ResponseBody
//@ResponseBody返回的对象，转换为 JSON 格式，通过 response 对象返回给客户端。
@RestController
@RequestMapping("/travelItem")
public class TravelItemController {

    // dubbo远程调用服务
    @Reference
    TravelItemService travelItemService;

    //
    @RequestMapping("/add")
    public Result add(@RequestBody TravelItem travelItem){
        try {
            travelItemService.add(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        } finally {

        }
    }
}
