package controller;

import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

public class LoginController {
    private final MemberService memberService = new MemberServiceImpl();

    public Member login(String username, String password) {
        return memberService.login(username, password);
    }
}
