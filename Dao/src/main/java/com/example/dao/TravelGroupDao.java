package com.example.dao;

import com.example.pojo.TravelGroup;

import java.util.HashMap;

public interface TravelGroupDao {
    void add(TravelGroup travelGroup);

    void addTravelItemAndGroups(HashMap<String, Integer> map);
}
