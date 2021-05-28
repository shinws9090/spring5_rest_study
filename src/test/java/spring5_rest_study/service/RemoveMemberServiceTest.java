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
import spring5_rest_study.mapper.MemberMapperTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
public class RemoveMemberServiceTest {
	
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private RemoveMemberService service;
	
	@Test
	public void testMemberList() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = service.removeMember((long) 1);
		Assert.assertEquals(1, res);
	}

}
