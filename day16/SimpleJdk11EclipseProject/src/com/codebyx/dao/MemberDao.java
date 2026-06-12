package com.codebyx.dao;

import java.util.List;
import java.util.Optional;

import com.codebyx.model.Member;

public interface MemberDao {
    Member save(Member member);

    List<Member> findAll();

    Optional<Member> findById(int id);

    boolean update(Member member);

    boolean deleteById(int id);
}
