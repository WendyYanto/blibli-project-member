package com.blibliproject.member.service;

import com.blibliproject.member.model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberService {
    Member create(Member member);

    Member findById(int id);

    List<Member> getAll();

    Member update(Member member, int id);

    Member delete(int id);
}
