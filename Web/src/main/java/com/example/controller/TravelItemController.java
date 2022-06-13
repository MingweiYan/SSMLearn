package com.example.controller;

import com.example.constant.MessageConstant;
import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.entity.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import com.example.pojo.TravelItem;
import com.example.service.TravelItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = null;
        try {
            pageResult = travelItemService.findPage(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return pageResult;
    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            travelItemService.delete(id);
            return new Result(true, MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_TRAVELITEM_FAIL);
        } finally {
        }
    }

    @RequestMapping("/getById")
    public Result getById(Integer id){
        try {
            TravelItem travelItem = travelItemService.getById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, travelItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        } finally {
        }
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody TravelItem travelItem){
        try {
            travelItemService.edit(travelItem);
            return new Result(true, MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_TRAVELITEM_FAIL);
        } finally {
        }
    }

    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<TravelItem> list = travelItemService.findAll();
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        } finally {
        }
    }
}
