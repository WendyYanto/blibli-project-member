package com.blibliproject.member.service;

import com.blibliproject.member.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImplementation implements MemberService{

    private List<Member> data = new ArrayList<Member>();

    @Override
    public Member create(Member member) {
        if(data.size() > 0 && findById(member.getId()) != null){
            return null;
        }

        data.add(member);
        return member;
    }

    @Override
    public Member findById(int id) {

        for(int i=0;i<data.size();i++){
            if(data.get(i).getId() == id){
                return data.get(i);
            }
        }

        return null;
    }

    @Override
    public List<Member> getAll() {
        if(data.size() == 0){
            return null;
        }

        return data;
    }

    @Override
    public Member update(Member member, int id) {
        Member current = findById(id);

        if(current != null){
            current.setName(member.getName());
            current.setAge(member.getAge());
            current.setEmail(member.getEmail());
            current.setPassword(member.getPassword());
            return current;
        }

        return null;
    }

    @Override
    public Member delete(int id) {
        Member current = findById(id);

        if(current != null){
            data.remove(current);
            return current;
        }

        return null;
    }
}
