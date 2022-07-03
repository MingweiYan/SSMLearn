package com.example.dao;


import com.example.pojo.OrderSetting;


import java.util.Date;
import java.util.List;
import java.util.Map;


public interface OrderSettingDao {

    long findCountByOrderDate(Date orderDate);

    void add(OrderSetting orderSetting);

    void editNumberByOrderDate(OrderSetting orderSetting);

    List<OrderSetting> getOrderSettingByMonth(Map<String, Object> map);
}
