package com.blibliproject.member.service;

import com.blibliproject.member.model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberService {
    Member create(Member member);

    Member findById(Long id);

    List<Member> getAll();

    Member update(Member member, Long id);

    Member delete(Long id);
}
