package com.example.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.constant.MessageConstant;
import com.example.entity.Result;
import com.example.pojo.Member;
import com.example.pojo.TravelGroup;
import com.example.service.TravelGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/travelGroup")
public class TravelGroupController {

    @Reference
    private TravelGroupService travelGroupService;

    @RequestMapping("/add")
    public Result add(Integer[] travelItemIds, @RequestBody TravelGroup travelGroup){
        try {
            travelGroupService.add(travelItemIds, travelGroup);

            return new Result(true, MessageConstant.ADD_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELGROUP_FAIL);
        } finally {
        }
    }

}
