package controller;

import java.util.List;

import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

public class MemberController {
    private final MemberService memberService = new MemberServiceImpl();

    public List<Member> findAll() {
        return memberService.findAll();
    }

    public void create(Member member) {
        memberService.create(member);
    }

    public void update(Member member) {
        memberService.update(member);
    }

    public void delete(Integer id) {
        memberService.delete(id);
    }
}
