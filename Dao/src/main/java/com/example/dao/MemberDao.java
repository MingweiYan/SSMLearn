package com.example.dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
    public Integer findMemberCountBeforeDate(String date);

    List<Map<String, Object>> findSetmealCount();

    int getTodayNewMember(String today);

    int getTotalMember();

    int getThisWeekAndMonthNewMember(String weekMonday);
}

