package com.pascaldev.projetwebtest.dto;

import com.pascaldev.projetwebtest.model.Member;
import lombok.RequiredArgsConstructor;

@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MemberDto {


    private Long id;
    private String address;
    private String nom;
    private String firstName;
    private String email;
    private String phone;

    public static MemberDto fromMember(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setAddress(member.getAddress());
        memberDto.setNom(member.getNom());
        memberDto.setFirstName(member.getFirstname());
        memberDto.setEmail(member.getEmail());
        memberDto.setPhone(member.getPhone());

        return memberDto;
    }

    public static Member fromMemberDto(MemberDto memberDto) {
        Member member = new Member();
        member.setAddress(memberDto.getAddress());
        member.setNom(memberDto.getNom());
        member.setFirstname(memberDto.getFirstName());
        member.setEmail(memberDto.getEmail());
        member.setPhone(memberDto.getPhone());
        return member;
    }

}
