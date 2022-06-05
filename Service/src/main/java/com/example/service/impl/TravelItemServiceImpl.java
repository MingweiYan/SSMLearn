package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.TravelItemDao;
import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.TravelItem;
import com.example.service.TravelItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void delete(Integer id) {
        travelItemDao.delete(id);
    }

    @Override
    public TravelItem getById(Integer id) {
        return travelItemDao.getById(id);
    }

    @Override
    public void edit(TravelItem travelItem) {
        travelItemDao.edit(travelItem);
    }

    @Override
    public List<TravelItem> findAll() {
        return travelItemDao.findAll();
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        // PageHelper首先将前端传递的参数保存到page这个对象中，接着将page的副本存放入ThreadLoacl中，
        // 这样可以保证分页的时候，参数互不影响，接着利用了mybatis提供的拦截器，取得ThreadLocal的值，重新拼装分页SQL，完成分页。
        // limit n,m
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page page = travelItemDao.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }
}
