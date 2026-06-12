package com.codebyx.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codebyx.dao.MemberDao;
import com.codebyx.model.Member;

public class MemberDaoMemoryImpl implements MemberDao {
    private final List<Member> members = new ArrayList<>();
    private int nextId = 1;

    public MemberDaoMemoryImpl() {
        save(new Member(0, "Allen", "allen@example.com", "0912-345-678"));
        save(new Member(0, "CodeByX Student", "student@example.com", "0988-888-888"));
    }

    @Override
    public Member save(Member member) {
        member.setId(nextId++);
        members.add(member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public Optional<Member> findById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Member updatedMember) {
        for (int i = 0; i < members.size(); i++) {
            Member current = members.get(i);
            if (current.getId() == updatedMember.getId()) {
                members.set(i, updatedMember);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return members.removeIf(member -> member.getId() == id);
    }
}
