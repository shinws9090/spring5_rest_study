package spring5_rest_study.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import spring5_rest_study.mapper.MemberMapperTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
public class RegisterMemberServiceTest {
	
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private RegisterMemberService service;
	
	@Test
	public void testregisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("13@sdfsd", "1111", "아아이", LocalDateTime.now());
		member.setId((long) 1);
		int res = service.registerMember(member);
		Assert.assertEquals(1, res);
	}

}
