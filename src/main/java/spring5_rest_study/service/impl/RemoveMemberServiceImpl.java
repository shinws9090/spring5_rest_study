package spring5_rest_study.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.RemoveMemberService;

@Service
public class RemoveMemberServiceImpl implements RemoveMemberService {
	private static final Log log = LogFactory.getLog(RemoveMemberServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public int removeMember(Long id) {
		int res = mapper.delete(id);
		log.debug("service - removeMember()"+id);
		return res;
	}

	

}
