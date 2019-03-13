package com.blibliproject.member.service;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImplementation implements MemberService{

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImplementation(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member create(Member member) { return memberRepository.save(member);}

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
            member.setId(id);
            return memberRepository.save(member);
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
