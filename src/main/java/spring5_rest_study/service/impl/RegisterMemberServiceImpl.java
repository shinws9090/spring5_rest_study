package spring5_rest_study.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.RegisterMemberService;

@Service
public class RegisterMemberServiceImpl implements RegisterMemberService {
	private static final Log log = LogFactory.getLog(RegisterMemberServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public int registerMember(Member member) {
		int res = mapper.insert(member);
		log.debug("service - registerMember()"+member);
		return res;
	}

	

}
