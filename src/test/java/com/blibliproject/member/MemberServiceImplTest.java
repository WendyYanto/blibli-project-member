package com.blibliproject.member;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.repository.MemberRepository;
import com.blibliproject.member.service.MemberServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.Optional;

public class MemberServiceImplTest {

    private MemberServiceImplementation memberService;

    private MemberRepository memberRepository;

    @Before
    public void setUp() throws Exception {
        memberRepository = Mockito.mock(MemberRepository.class);
        memberService = new MemberServiceImplementation(memberRepository);
    }

    @Test
    public void testSave(){
        Member member = new Member(1L,"Wenyd","yantosd@admci.com","password",1);

        Mockito.when(memberRepository.save(member)).thenReturn(member);

        Member returnData = memberService.create(member);

        Assert.assertTrue("Must NOT NULL",returnData.getId() == member.getId());

        Mockito.verify(memberRepository,Mockito.times(1)).save(member);
    }

    @Test
    public void testFindByID(){
        Member member = new Member(1L,"Wenyd","yantosd@admci.com","password",1);

        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        Mockito.when(memberRepository.findById(2L)).thenReturn(Optional.empty());

        Member result1 = memberService.findById(1L);
        Assert.assertTrue(result1 != null);

        Member result2 = memberService.findById(2L);
        Assert.assertTrue(result2 == null);
    }

}
