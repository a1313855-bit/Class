package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
    Member login(String username, String password);

    void insert(Member member);

    void update(Member member);

    void deleteById(Integer id);

    Member findById(Integer id);

    List<Member> findAll();
}
