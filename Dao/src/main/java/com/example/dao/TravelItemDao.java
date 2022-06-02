package com.example.dao;


import com.example.entity.PageResult;
import com.example.pojo.TravelItem;
import com.github.pagehelper.Page;

public interface TravelItemDao {

    void add(TravelItem travelItem );

    Page findPage(String queryString);

    void delete(Integer id);
}
