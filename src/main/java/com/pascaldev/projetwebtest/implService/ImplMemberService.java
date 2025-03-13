package com.pascaldev.projetwebtest.implService;

import com.pascaldev.projetwebtest.dto.MemberDto;
import com.pascaldev.projetwebtest.model.Member;
import com.pascaldev.projetwebtest.repository.MemberRepository;
import com.pascaldev.projetwebtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImplMemberService implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberDto findMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.map(MemberDto::fromMember).orElse(null);

    }

    @Override
    public List<MemberDto> findAllMembers() {
        return memberRepository.findAll().stream().map(MemberDto::fromMember).collect(Collectors.toList());
    }

    @Override
    public List<MemberDto> findMemberByAddress(String address) {
        List<MemberDto> memberDos = new ArrayList<>();
        List<Member> listMember = memberRepository.findMemberByAddress(address);
        for (Member member : listMember) {
            MemberDto memberDto = MemberDto.fromMember(member);
            memberDos.add(memberDto);
        }
        return memberDos;
    }



    @Override
    public MemberDto updateMember(Long id, MemberDto member) {
        Optional<Member> membreOptional = memberRepository.findById(id);
        if (membreOptional.isPresent()) {
            membreOptional.get().setNom(member.getNom());
            membreOptional.get().setFirstname(member.getFirstName());
            membreOptional.get().setEmail(member.getEmail());
            membreOptional.get().setAddress(member.getAddress());
            membreOptional.get().setPhone(member.getPhone());
            memberRepository.save(membreOptional.get());
            return MemberDto.fromMember(membreOptional.get());
        }else {
            return null;
        }

    }

    @Override
    public MemberDto saveMember(MemberDto memberDto) {
        Optional<Member> memberFind = memberRepository.findById(memberDto.getId());
        if (memberFind.isPresent()) {
            return updateMember(memberDto.getId(), memberDto);
        }else {
            Member memberSave =  memberRepository.save(MemberDto.fromMemberDto(memberDto));
            return MemberDto.fromMember(memberSave);
        }


    }

    @Override
    public void deleteMember(Long id) {
        Optional<Member> memberFind = memberRepository.findById(id);
        memberFind.ifPresent(memberRepository::delete);

    }

    @Override
    public void deleteAllMembers() {
        memberRepository.deleteAll();
    }
}
