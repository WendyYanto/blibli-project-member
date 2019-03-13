package com.blibliproject.member;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.repository.MemberRepository;
import com.blibliproject.member.service.MemberServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void testGetAll(){
        Member member = new Member(1L,"Wenyd","yantosd@admci.com","password",1);
        Member second_member = new Member(2L,"James","james@admin.com","password",10);

        List<Member> lists = new ArrayList<>();
        lists.add(member);
        lists.add(second_member);

        Mockito.when(memberRepository.findAll()).thenReturn(lists);

        Assert.assertTrue("lists return size of 2",lists.size() == 2);
    }

    @Test
    public void testUpdate(){
        Member member = new Member(null,"Wenyd","yantosd@admci.com","password",1);
        Member currentMember = new Member(1L,"Wenyd","yantosd@admci.com","password",1);
        Member updatedMember = new Member(1L,"James","james@admin.com","password",10);

        Mockito.when(memberRepository.save(member)).thenReturn(currentMember);
        Mockito.when(memberRepository.save(updatedMember)).thenReturn(updatedMember);

        Member createdData = memberRepository.save(member);
        Member updateData = memberRepository.save(updatedMember);

        Assert.assertTrue("updatedData Has ID of 1",updateData.getId() == 1L);
        Assert.assertTrue("updateData has Name of James",updateData.getName().equals("James"));
    }

    @Test
    public void testDelete(){
        Member member = new Member(1L,"Wenyd","yantosd@admci.com","password",1);
        List<Member> lists = new ArrayList<>();
        lists.add(member);
        lists.remove(member);

        Mockito.when(memberRepository.findAll()).thenReturn(lists);
        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        List<Member> currentLists = memberService.getAll();
        Member data = memberService.delete(1L);

        Assert.assertTrue(lists.size()==0);
        Assert.assertTrue(data.getId() == 1L);
    }

}
