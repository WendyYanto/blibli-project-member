package com.blibliproject.member.controller;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> getAllProducts(){
        return memberService.getAll();
    }

    @RequestMapping(
            value = "/members",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }

    @RequestMapping(
            value = "/members/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById(@PathVariable("id") int id){
        return memberService.findById(id);
    }

    @RequestMapping(
            value = "/members/edit/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member updateProduct(@PathVariable("id") int id, @RequestBody Member product){
        return memberService.update(product,id);
    }

    @RequestMapping(
            value = "/members/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member deleteProduct(@PathVariable("id") int id){
        return memberService.delete(id);
    }
}
