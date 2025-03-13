package com.pascaldev.projetwebtest.repository;

import com.pascaldev.projetwebtest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMemberByAddress(String address);
}
