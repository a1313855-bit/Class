package service;

import java.util.List;

import model.Member;

public interface MemberService {
    Member login(String username, String password);

    void create(Member member);

    void update(Member member);

    void delete(Integer id);

    List<Member> findAll();
}
