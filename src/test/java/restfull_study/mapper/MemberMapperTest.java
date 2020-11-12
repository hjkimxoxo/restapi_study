package restfull_study.mapper;


import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import restfull_study.config.ControllerConfig;
import restfull_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {
	
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;

	private static Member member;


	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectMemberByAll();
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectMemberById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		member = mapper.selectMemberById(39);
		System.out.println(member);
	}
	
	//@Test
	public void test03InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test25@test.co.kr", "1234", "테스트", LocalDateTime.now());
		int res = mapper.insertMember(member);
		Assert.assertEquals(1, res);
		System.out.println("---확인---");
		List<Member> list = mapper.selectMemberByAll();
		list.stream().forEach(System.out::println);
	}
	

	//@Test
	public void test04UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		System.out.println(member);
		member.setName("테스트변경");
		member.setPassword("비밀번호변경");
		int res = mapper.updateMember(member);
		Assert.assertEquals(1, res);
		System.out.println("---test83 -> 확인---");
		List<Member> list = mapper.selectMemberByAll();
		list.stream().forEach(System.out::println);
		
	}

	//@Test
	public void test05DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = mapper.deleteMember(member.getId());
		Assert.assertEquals(1, res);
		System.out.println("---test83 -> 확인---");
		List<Member> list = mapper.selectMemberByAll();
		list.stream().forEach(System.out::println);
		
		
	}

}
