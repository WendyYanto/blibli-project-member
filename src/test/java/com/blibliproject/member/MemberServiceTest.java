//package com.blibliproject.member;
//
//import com.blibliproject.member.model.Member;
//import com.blibliproject.member.service.MemberServiceImplementation;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//
//public class MemberServiceTest {
//
//    private MemberServiceImplementation memberService;
//
//    @Before
//    public void createMemberServiceInstance(){
//        memberService = new MemberServiceImplementation();
//    }
//
//    @Test
//    public void testMemberIsNullBeforeInsert(){
//        List<Member> data = memberService.getAll();
//        Assert.assertTrue("Data Is NULL",data == null);
//    }
//
//    @Test
//    public void testMemberIsCreated(){
//        Member current = new Member(
//            1,
//            "Wendy",
//            "Wendy@gmail.com",
//            "Password",
//            20
//        );
//
//        Member response = memberService.create(current);
//
//        Assert.assertTrue("List Size Is Equals To 1",memberService.getAll().size() == 1);
//    }
//
//    @Test
//    public void testMemberCreatedAndFind(){
//        Member current = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        memberService.create(current);
//
//        Member response = memberService.findById(1);
//
//        Assert.assertTrue("Member Object Is The Same To Object Added In List",response == current);
//        Assert.assertTrue("Member Object Has Id of 1",response.getId() == 1);
//        Assert.assertTrue("Member Object Has Name of 'Wendy' ",response.getName().equals("Wendy"));
//    }
//
//    @Test
//    public void testMemberGetAllReturnSameSize(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        Member secondCurrent = new Member(
//                2,
//                "Wendy1",
//                "Wendy@gmail1.com",
//                "Password1",
//                21
//        );
//
//        memberService.create(firstCurrent);
//        memberService.create(secondCurrent);
//
//        List<Member> responseLists = memberService.getAll();
//
//        Assert.assertTrue("Member GetAll Must Return Size Of 2",responseLists.size() == 2);
//    }
//
//    public void testMemberCannotInsertDuplicateID(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        Member secondCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        memberService.create(firstCurrent);
//        Member secondCurrentInserted  = memberService.create(secondCurrent);
//
//        Assert.assertTrue("secondCurrentInserted Must Return Null",secondCurrentInserted == null);
//        Assert.assertTrue("ResponseList Must Only Has The Size Of 1",memberService.getAll().size() == 1);
//    }
//
//    @Test
//    public void memberUpdateData(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        Member updateCurrent = new Member(
//                1,
//                "Yanto",
//                "Yanto@gmail.com",
//                "Admin",
//                32
//        );
//
//        memberService.create(firstCurrent);
//
//        Member retrievedMember = memberService.findById(1);
//
//        Assert.assertTrue("retrievedMember Must Not Null",retrievedMember != null);
//
//        Member updated = memberService.update(updateCurrent,1);
//
//        Assert.assertTrue("updateCurrent Has The Same Name AS Updated",updated.getName().equals(updateCurrent.getName()));
//        Assert.assertTrue("updateCurrent Has The Same ID of 1",updated.getId() == 1);
//    }
//
//    @Test
//    public void testMemberUpdatedWithIDNotFound(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        Member updateCurrent = new Member(
//                1,
//                "Yanto",
//                "Yanto@gmail.com",
//                "Admin",
//                32
//        );
//
//        memberService.create(firstCurrent);
//        Member updated = memberService.update(updateCurrent,2);
//
//        Assert.assertTrue("updated Must Return NULL",updated == null);
//    }
//
//    @Test
//    public void testDeleteReturnNullIfIDNotPresent(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        memberService.create(firstCurrent);
//
//        Member response = memberService.delete(2);
//
//        Assert.assertTrue("response Must Return NULL",response == null);
//    }
//
//    @Test
//    public void testDelete(){
//        Member firstCurrent = new Member(
//                1,
//                "Wendy",
//                "Wendy@gmail.com",
//                "Password",
//                20
//        );
//
//        Member secondCurrent = new Member(
//                2,
//                "Wendy1",
//                "Wendy@gmail1.com",
//                "Password1",
//                21
//        );
//
//        memberService.create(firstCurrent);
//        memberService.create(secondCurrent);
//
//        Member memberDeleteId1 = memberService.delete(1);
//
//        List<Member> responseLists = memberService.getAll();
//
//        Assert.assertTrue("productDeleteId1 Must Contain ID of 1",memberDeleteId1.getId() == 1);
//        Assert.assertTrue("Total responseList Must Only Have Size of 1",responseLists.size() == 1);
//    }
//}
