package com.example.service;

import com.example.pojo.Member;

import java.util.List;

public interface MemberService {

    List<Integer> findMemberCountByMonth(List<String> monthsList);

    Member findByTelephone(String telephone);

    void add(Member member);

}
