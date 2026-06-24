package service.impl;

import java.util.List;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import exception.AppException;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao = new MemberDaoImpl();

    @Override
    public Member login(String username, String password) {
        requireText(username, "帳號不可空白");
        requireText(password, "密碼不可空白");
        Member member = memberDao.login(username.trim(), password.trim());
        if (member == null) {
            throw new AppException("登入失敗，帳號或密碼錯誤");
        }
        return member;
    }

    @Override
    public void create(Member member) {
        validateMember(member);
        if (member.getRole() == null || member.getRole().trim().isEmpty()) {
            member.setRole("USER");
        }
        memberDao.insert(member);
    }

    @Override
    public void update(Member member) {
        if (member.getId() == null) {
            throw new AppException("請先選擇要修改的會員");
        }
        validateMember(member);
        memberDao.update(member);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new AppException("請先選擇要刪除的會員");
        }
        memberDao.deleteById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    private void validateMember(Member member) {
        if (member == null) {
            throw new AppException("會員資料不可為空");
        }
        requireText(member.getUsername(), "帳號不可空白");
        requireText(member.getPassword(), "密碼不可空白");
        requireText(member.getName(), "姓名不可空白");
    }

    private void requireText(String value, String message) {
        if (value == null || value.trim().isEmpty()) {
            throw new AppException(message);
        }
    }
}
