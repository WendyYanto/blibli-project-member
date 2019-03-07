package com.blibliproject.member.service;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImplementation implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> data = memberRepository.findById(id);

        if(data.isPresent()){
            return data.get();
        }

        return null;
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member update(Member member, Long id) {

        Member current = findById(id);

        if(current != null){
            current.setId(id);
            return memberRepository.save(current);
        }

        return null;
    }

    @Override
    public Member delete(Long id) {

        Member current = findById(id);

        if(current != null){
            memberRepository.delete(current);
            return current;
        }

        return null;
    }

}
