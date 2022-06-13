package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.TravelGroupDao;
import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.TravelGroup;
import com.example.service.TravelGroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

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

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page page = travelGroupDao.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public TravelGroup getById(Integer id) {
        return travelGroupDao.getById(id);
    }

    @Override
    public void edit(Integer[] travelItemIds, TravelGroup travelGroup) {
        Integer travelGroupId = travelGroup.getId();
        travelGroupDao.delete(travelGroupId);
        travelGroupDao.edit(travelGroup);
        setTravelItemsAndGroups(travelItemIds, travelGroupId);
    }

    @Override
    public List<TravelGroup> findAll() {
        return travelGroupDao.findAll();
    }

    @Override
    public List<Integer> getTravelitemIdsByTravelGroupId(Integer travelGroupId) {
        return travelGroupDao.getTravelitemIdsByTravelGroupId(travelGroupId);
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
