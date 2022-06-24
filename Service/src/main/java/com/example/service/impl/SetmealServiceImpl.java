package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.constant.RedisConstant;
import com.example.dao.SetmealDao;
import com.example.entity.PageResult;
import com.example.entity.QueryPageBean;
import com.example.pojo.Setmeal;
import com.example.service.SetmealService;
import com.example.service.SetmealService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealDao setmealDao;

    @Autowired
    private JedisPool jedisPool;


    @Override
    public void add(Integer[] travelGroupIds, Setmeal setmeal) {
        setmealDao.add(setmeal);
        Integer setmealId = setmeal.getId();
        setSetmealAndTravelGroup(travelGroupIds, setmealId);
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());
    }

    private void setSetmealAndTravelGroup(Integer[] travelGroupIds, Integer setmealId) {
        if(travelGroupIds != null && travelGroupIds.length != 0){
            for(Integer travelGroupId : travelGroupIds){
                HashMap<String, Integer> map = new HashMap<>();
                map.put("travelGroupId", travelGroupId);
                map.put("setmealId", setmealId);
                setmealDao.setSetmealAndTravelGroup(map);
            }
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page page = setmealDao.findPage(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Setmeal getById(Integer id) {
        return setmealDao.getById(id);
    }

    @Override
    public void edit(Integer[] travelGroupIds, Setmeal setmeal) {
        Integer setmealId = setmeal.getId();
        setmealDao.delete(setmealId);
        setmealDao.edit(setmeal);
        setSetmealAndTravelGroup(travelGroupIds, setmealId);
    }

    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }

    @Override
    public List<Integer> getTravelitemIdsBySetmealId(Integer setmealId) {
        return setmealDao.getTravelitemIdsBySetmealId(setmealId);
    }


}
