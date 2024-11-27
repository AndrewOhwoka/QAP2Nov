
package com.keyin.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getAllMembers")
    public Iterable<Member> getListOfMembersInDB() {
        return memberService.getAllMembers();
    }
    @PostMapping("/createAllMembers")
    public Member CreateMember(@RequestBody Member member) {
        return memberService.createNewMember( member);

    }

}
