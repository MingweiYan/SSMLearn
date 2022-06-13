package com.example.service;

import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.TravelGroup;

import java.util.List;

public interface TravelGroupService {

    void add(Integer[] travelItemIds, TravelGroup travelGroup);

    PageResult findPage(QueryPageBean queryPageBean);

    TravelGroup getById(Integer id);

    void edit(Integer[] travelItemIds, TravelGroup travelGroup);

    List<TravelGroup> findAll();

    List<Integer> getTravelitemIdsByTravelGroupId(Integer travelGroupId);
}
