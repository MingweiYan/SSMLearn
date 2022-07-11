package com.example.dao;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    public int getTodayOrderNumber(String today);

    public int getTodayVisitsNumber(String today);

    public int getThisWeekAndMonthOrderNumber(Map<String, Object> paramWeek);

    public int getThisWeekAndMonthVisitsNumber(Map<String, Object> paramWeekVisit);

    public List<Map<String,Object>> findHotSetmeal();
}
