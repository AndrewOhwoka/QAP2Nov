package com.keyin.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }
}
