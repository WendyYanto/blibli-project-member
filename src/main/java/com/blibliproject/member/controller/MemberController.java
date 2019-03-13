package com.blibliproject.member.controller;

import com.blibliproject.member.model.ApiKey;
import com.blibliproject.member.model.Member;
import com.blibliproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(
        value = "/members",
        method = RequestMethod.GET
    )
    public String check(ApiKey apiKey){
        return "Hello World";
    }

    @RequestMapping(
            value = "/api/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> getAllMembers(){
        return memberService.getAll();
    }

    @RequestMapping(
            value = "/api/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }

    @RequestMapping(
            value = "/api/members/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }

    @RequestMapping(
            value = "/api/members/edit/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member updateMember(@PathVariable("id") Long id, @RequestBody Member member){
        return memberService.update(member,id);
    }

    @RequestMapping(
            value = "/api/members/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member deleteMember(@PathVariable("id") Long id){
        return memberService.delete(id);
    }
}
