package com.example.dao;


import com.example.pojo.Setmeal;
import com.example.pojo.TravelItem;
import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;

public interface SetmealDao {


    void add(Setmeal setmeal);

    void setSetmealAndTravelGroup(HashMap<String, Integer> map);

    Page findPage(String queryString);
}
