package com.example.service;

import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealService {

    void add(Integer[] setmealIds, Setmeal setmeal);

    PageResult findPage(QueryPageBean queryPageBean);

    List<Map<String, Object>> findSetmealCount();
}
