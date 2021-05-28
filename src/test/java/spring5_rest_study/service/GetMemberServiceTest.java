package spring5_rest_study.service;

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


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
public class GetMemberServiceTest {
	
	private static final Log log = LogFactory.getLog(GetMemberServiceTest.class);
	
	@Autowired
	private GetMemberService service;
	
	@Test
	public void testGetMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = service.getMember((long) 21);
		Assert.assertNotNull(member);
		log.debug(member.toString());
	}

}
