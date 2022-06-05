package com.example.dao;


import com.example.entity.PageResult;
import com.example.pojo.TravelItem;
import com.github.pagehelper.Page;

import java.util.List;

public interface TravelItemDao {

    void add(TravelItem travelItem );

    Page findPage(String queryString);

    void delete(Integer id);

    TravelItem getById(Integer id);

    void edit(TravelItem travelItem);

    List<TravelItem> findAll();
}
