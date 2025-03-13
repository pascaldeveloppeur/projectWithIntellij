package com.pascaldev.projetwebtest.controller;

import com.pascaldev.projetwebtest.dto.MemberDto;
import com.pascaldev.projetwebtest.implService.ImplMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final ImplMemberService memberService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MemberDto> addMember(@RequestBody MemberDto memberDto) {
        log.info("Adding member {}", memberDto);
        try {
         log.info("Member: {}", memberDto);
         MemberDto newMemberDto = memberService.saveMember(memberDto);
         return new ResponseEntity<>(newMemberDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MemberDto getMember(@PathVariable Long id) {
        log.info("Getting member {}", id);

        try{
            log.trace("Member: {}", id);
            MemberDto memberDto = memberService.findMemberById(id);
            log.trace("Member: {}", memberDto);
            return ResponseEntity.status(HttpStatus.OK).body(memberDto).getBody();

        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDto> getMembers() {
        log.info("Getting members");

        try{
            log.trace("Members");
            List<MemberDto> memberDtoList = memberService.findAllMembers();
            log.trace("Members: {}", memberDtoList);
            return ResponseEntity.status(HttpStatus.OK).body(memberDtoList).getBody();
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public  List<MemberDto> getMembersByAddress(String address) {
        log.info("Getting members by address {}", address);
        try {
            List<MemberDto> memberDtoListByAddress = memberService.findMemberByAddress(address);
            log.trace("Members: {}", memberDtoListByAddress);
            return ResponseEntity.status(HttpStatus.OK).body(memberDtoListByAddress).getBody();
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMember(Long id, MemberDto memberDto) {
        log.info("Updating member {}", memberDto);

        try{
            log.info("Member: {}", memberDto);
            MemberDto updatedMemberDto = memberService.updateMember(id, memberDto);
            return new ResponseEntity<>(updatedMemberDto, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        log.info("Deleting member {}", id);

        try{
            log.info("Member: {}", id);
            memberService.deleteMember(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAllMembers() {
        log.info("Deleting members");
        try{
            log.info("Members");
            memberService.deleteAllMembers();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
