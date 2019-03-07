package com.blibliproject.member;

import com.blibliproject.member.model.Member;
import com.blibliproject.member.repository.MemberRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void memberListMustReturnNull(){
        List<Member> lists = memberRepository.findAll();
        Assert.assertTrue("List Must Return Size of 0 On First Create",lists.size() == 0);
    }

    @Test
    public void memberCreatedMustReturnTheSameObjectInserted(){
        Member firstMember = new Member(
            null,
            "Wendy",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member firstMemberInserted = memberRepository.save(firstMember);

        Assert.assertTrue("firstMember Is The Same As firstMemberInserted",firstMember == firstMemberInserted);
    }

    @Test
    public void memberCreatedCanBeFindById(){
        Member firstMember = new Member(
            null,
            "Wendy",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member firstMemberInserted = memberRepository.save(firstMember);
        Long firstMemberInsertedId = firstMemberInserted.getId();

        Optional<Member> findMemberByID = memberRepository.findById(firstMemberInsertedId);

        Assert.assertTrue("firstMemberInsertedId Must Return Same ID as firstMemberInsertedId",findMemberByID.get().getId() == firstMemberInsertedId);
    }

    @Test
    public void memberNotCreatedCannotBeFindByID(){

        Member firstMember = new Member(
                null,
                "Wendy",
                "yanto.wendy@gmail.com",
                "password",
                20
        );

        memberRepository.save(firstMember);

        Optional<Member> findMemberByID = memberRepository.findById(100L);

        Assert.assertTrue("findMemberByID Must Return NULL",findMemberByID.isPresent() == false);
    }

    @Test
    public void memberGetAllMustReturnTheSameSizeInserted(){
        Member firstMember = new Member(
            null,
            "Wendy",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member secondMember = new Member(
            null,
            "Yanto",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member firstMemberInserted = memberRepository.save(firstMember);
        Member secondMemberInserted = memberRepository.save(secondMember);

        List<Member> lists = memberRepository.findAll();

        Assert.assertTrue("firstMemberInserted Has Same Name As firstMember",firstMember.getName() == firstMemberInserted.getName());
        Assert.assertTrue("secondMemberInserted Has Same Name As secondMember",secondMember.getName() == secondMemberInserted.getName());
        Assert.assertTrue("lists Must Return Size of 2",lists.size() == 2);
    }

    @Test
    public void memberUpdateMustReturnUpdatedObjectAndSameID(){
        Member firstMember = new Member(
                null,
                "Wendy",
                "yanto.wendy@gmail.com",
                "password",
                20
        );

        Member firstMemberInserted = memberRepository.save(firstMember);
        Long ID = firstMemberInserted.getId();

        Member secondMember = new Member(
            ID,
            "Yanto",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member expectedReturnID = memberRepository.save(secondMember);

        Assert.assertTrue("ID Should Be The Same",ID == expectedReturnID.getId());
        Assert.assertTrue("Name Cannot The Same",expectedReturnID.getName().equals("Wendy") == false);
        Assert.assertTrue("Name Must Have Change",expectedReturnID.getName().equals("Yanto") == true);

    }

    @Test
    public void deleteMember(){
        Member firstMember = new Member(
            null,
            "Wendy",
            "yanto.wendy@gmail.com",
            "password",
            20
        );

        Member GetID = memberRepository.save(firstMember);
        memberRepository.deleteById(GetID.getId());

        Boolean checkID = memberRepository.existsById(GetID.getId());
        List<Member> lists = memberRepository.findAll();

        Assert.assertTrue("checkID Must Return False",checkID == false);
        Assert.assertTrue("List Musr Return 0",lists.size() == 0);
    }

    @After
    public void deleteAllDataInTable(){
        memberRepository.deleteAll();
    }
}
