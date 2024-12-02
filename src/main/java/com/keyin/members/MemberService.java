package com.keyin.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createNewMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> searchByID(Long id) {
        return memberRepository.findById(id);
    }

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }
}