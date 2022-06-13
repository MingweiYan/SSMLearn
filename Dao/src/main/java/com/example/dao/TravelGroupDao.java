package com.example.dao;

import com.example.pojo.TravelGroup;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TravelGroupDao {
    void add(TravelGroup travelGroup);

    void addTravelItemAndGroups(HashMap<String, Integer> map);

    Page findPage(@Param("queryString") String queryString);

    List<Integer> getTravelitemIdsByTravelGroupId(Integer travelGroupId);

    List<TravelGroup> findAll();

    void edit(TravelGroup travelGroup);

    TravelGroup getById(Integer id);

    void delete(Integer travelGroupId);
}
