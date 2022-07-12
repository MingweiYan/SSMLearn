package com.example.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dao.MemberDao;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    // 根据月份统计会员数量
    @Override
    public List<Integer> findMemberCountByMonth(List<String> months) {
        List<Integer> list = new ArrayList<>();

        if(months!=null && months.size()>0){
            for (String month : months) {
                int count = memberDao.findMemberCountByMonth(month);
                list.add(count);
            }
        }

        return list;
    }

}
