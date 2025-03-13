package com.pascaldev.projetwebtest.service;

import com.pascaldev.projetwebtest.dto.MemberDto;
import com.pascaldev.projetwebtest.model.Member;

import java.util.List;


public interface MemberService {

    MemberDto findMemberById(Long id);
    List<MemberDto> findAllMembers();
    List<MemberDto> findMemberByAddress(String address);
    MemberDto updateMember(Long id, MemberDto member);
    MemberDto saveMember(MemberDto member);
    void deleteMember(Long id);
    void deleteAllMembers();

;


}
