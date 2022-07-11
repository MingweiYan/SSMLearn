package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.MemberDao;
import com.example.service.MemberService;
import com.example.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {



    @Service(interfaceClass = MemberService.class)
    @Transactional
    public class MemberServiceImpl implements MemberService {

        @Autowired
        private MemberDao memberDao;

        // 根据月份统计会员数量
        public List<Integer> findMemberCountByMonth(List<String> monthsList) {
            List<Integer> memeberCountList = new ArrayList<Integer>();
            if(monthsList!=null && monthsList.size()>0){
                for (String months : monthsList) {
                    //String regTime = months+"-31";
                    // 获取指定月份的最后一天
                    String regTime =  DateUtils.getLastDayOfMonth(months);
                    //  迭代过去12个月，每个月注册会员的数量，根据注册日期查询
                    Integer memeberCount = memberDao.findMemberCountBeforeDate(regTime);
                    memeberCountList.add(memeberCount);
                }
            }
            return memeberCountList;
        }

    }
