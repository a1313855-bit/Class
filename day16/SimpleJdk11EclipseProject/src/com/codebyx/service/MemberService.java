package com.codebyx.service;

import java.util.List;
import java.util.Optional;

import com.codebyx.dao.MemberDao;
import com.codebyx.model.Member;

public class MemberService {
    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member createMember(String name, String email, String phone) {
        validateName(name);
        validateEmail(email);
        return memberDao.save(new Member(0, name, email, phone));
    }

    public List<Member> getAllMembers() {
        return memberDao.findAll();
    }

    public Optional<Member> getMemberById(int id) {
        return memberDao.findById(id);
    }

    public boolean updateMember(int id, String name, String email, String phone) {
        validateName(name);
        validateEmail(email);
        return memberDao.update(new Member(id, name, email, phone));
    }

    public boolean deleteMember(int id) {
        return memberDao.deleteById(id);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("姓名不可空白");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email 格式錯誤，必須包含 @");
        }
    }
}
