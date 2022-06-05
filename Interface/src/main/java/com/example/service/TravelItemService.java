package com.example.service;

import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.TravelItem;

import java.util.List;

public interface TravelItemService {

    void add(TravelItem travelItem);

    PageResult findPage(QueryPageBean queryPageBean);

    void delete(Integer id);

    TravelItem getById(Integer id);

    void edit(TravelItem travelItem);

    List<TravelItem> findAll();
}
