package com.example.service;

import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.Setmeal;
import com.example.pojo.TravelGroup;

import java.util.List;

public interface SetmealService {

    void add(Integer[] setmealIds, Setmeal setmeal);

    PageResult findPage(QueryPageBean queryPageBean);

}
