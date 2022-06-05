package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.TravelGroupDao;
import com.example.pojo.TravelGroup;
import com.example.service.TravelGroupService;
import com.example.service.TravelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service(interfaceClass = TravelGroupService.class)
@Transactional
public class TravelGroupServiceImpl implements TravelGroupService {

    @Autowired
    TravelGroupDao travelGroupDao;

    @Override
    public void add(Integer[] travelItemIds, TravelGroup travelGroup) {
        travelGroupDao.add(travelGroup);
        Integer travelGroupId = travelGroup.getId();
        setTravelItemsAndGroups(travelItemIds, travelGroupId);
    }
    private void setTravelItemsAndGroups(Integer[] travelItemIds, Integer travelGroupId) {
        if(travelItemIds != null && travelItemIds.length != 0){
            for(Integer travelItemId : travelItemIds){
                HashMap<String, Integer> map = new HashMap<>();
                map.put("travelItemId", travelItemId);
                map.put("travelGroupId", travelGroupId);
                travelGroupDao.addTravelItemAndGroups(map);
            }
        }
    }
}
