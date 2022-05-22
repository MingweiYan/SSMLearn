package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.TravelItemDao;
import com.example.pojo.TravelItem;
import com.example.service.TravelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

// Dubbo 服务
@Service(interfaceClass = TravelItemService.class)
// 所有方法都会开开启事务
@Transactional
public class TravelItemServiceImpl implements TravelItemService{

    @Autowired
    TravelItemDao travelItemDao;

    @Override
    public void add(TravelItem travelItem) {
        travelItemDao.add(travelItem);
    }
}
