package spring5_rest_study.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.GetMemberService;

@Service
public class GetMemberServiceImpl implements GetMemberService {
	private static final Log log = LogFactory.getLog(GetMemberServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	
	@Override
	public Member getMember(Long id) {
		Member member = mapper.selectById(id);
		log.debug("service - getMember()"+id);
		return member;
	}

}
