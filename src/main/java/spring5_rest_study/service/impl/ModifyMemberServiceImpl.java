package spring5_rest_study.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.ModifyMemberService;

@Service
public class ModifyMemberServiceImpl implements ModifyMemberService {
	private static final Log log = LogFactory.getLog(ModifyMemberServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	

	@Override
	public int modifyMember(Member member) {
		int res = mapper.update(member);
		log.debug("service - modifyMember()"+member);
		return res;
	}

}
