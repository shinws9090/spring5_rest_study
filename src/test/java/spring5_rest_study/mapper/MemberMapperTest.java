package spring5_rest_study.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
public class MemberMapperTest {
	
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}


	
	@Test
	public void testSelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member member = new Member();
		member.setId((long) 6);
		Member selectStd = mapper.selectById(member.getId());
		log.debug(selectStd.toString());
		Assert.assertNotNull(selectStd);
	}

	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test01InsertStudent() {

		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("13@sdfsd", "1111", "아아이", LocalDateTime.now());
		member.setId((long) 1);
		int res = mapper.insert(member);
		Assert.assertEquals(1, res);
	}
	@Test
	public void test02UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("13@sdfsd", "2222", "아아이", LocalDateTime.now());
		member.setId((long) 1);
		int res = mapper.update(member);
		Assert.assertEquals(1, res);

	}
	@Test
	public void test03DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = mapper.delete((long) 1);
		Assert.assertEquals(1, res);

	}

}
