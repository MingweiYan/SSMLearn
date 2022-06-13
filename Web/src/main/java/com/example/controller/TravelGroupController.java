package com.example.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.constant.MessageConstant;
import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.entity.Result;
import com.example.pojo.Member;
import com.example.pojo.TravelGroup;
import com.example.pojo.TravelGroup;
import com.example.service.TravelGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = null;
        try {
            pageResult = travelGroupService.findPage(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return pageResult;
    }

    @RequestMapping("/getById")
    public Result getById(Integer id){
        try {
            TravelGroup travelGroup= travelGroupService.getById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, travelGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        } finally {
        }
    }

    @RequestMapping("/edit")
    public Result edit(Integer[] travelItemIds, @RequestBody TravelGroup travelGroup){
        try {
            travelGroupService.edit(travelItemIds, travelGroup);
            return new Result(true, MessageConstant.EDIT_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_TRAVELGROUP_FAIL);
        } finally {
        }
    }

    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<TravelGroup> list = travelGroupService.findAll();
            return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELGROUP_FAIL);
        } finally {
        }
    }

    @RequestMapping("/getTravelitemIdsByTravelGroupId")
    public Result getTravelitemIdsByTravelGroupId(Integer travelGroupId){
        try {
            List<Integer> list = travelGroupService.getTravelitemIdsByTravelGroupId(travelGroupId);
            return new Result(true, "根据跟团游id查询自由行成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "根据跟团游id查询自由行失败");
        } finally {
        }
    }

}
