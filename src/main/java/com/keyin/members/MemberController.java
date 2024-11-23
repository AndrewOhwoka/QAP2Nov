
package com.keyin.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getAllMembers")
    public Iterable<Member> getListOfMembersInDB() {
        return memberService.getAllMembers();
    }
}
