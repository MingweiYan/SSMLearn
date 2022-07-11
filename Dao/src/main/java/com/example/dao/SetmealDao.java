package com.example.dao;


import com.example.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SetmealDao {

    void add(Setmeal setmeal);

    void addSetmealAndTravelGroup(HashMap<String, Integer> map);

    Page findPage(String queryString);

    List<Map<String, Object>> findSetmealCount();
}
