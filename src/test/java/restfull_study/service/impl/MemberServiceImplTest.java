package restfull_study.service.impl;

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
import restfull_study.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceImplTest {
	private static final Log log = LogFactory.getLog(MemberServiceImplTest.class);
	private static Member member;
	
	@Autowired
	private MemberService service;
	
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01GetList() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = service.getList();
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02GetMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		member = service.getMember(35);
	}

	@Test
	public void test03RegisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test28@test26.co.kr", "1234", "테스트26", LocalDateTime.now());
		int res = service.registerMember(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04ModifyMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		member.setName("테스트26변경");
		member.setPassword("비밀번호변경");
		int res = service.modifyMember(member);
		Assert.assertEquals(1, res);
		System.out.println("----확인----");
		List<Member> list = service.getList();
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test05RemoveMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = service.removeMember(member.getId());
		Assert.assertEquals(1, res);
		System.out.println("----확인----");
		List<Member> list = service.getList();
		list.stream().forEach(System.out::println);
	}

}
