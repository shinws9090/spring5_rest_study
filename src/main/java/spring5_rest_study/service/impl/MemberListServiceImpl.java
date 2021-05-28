package spring5_rest_study.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.MemberListService;

@Service
public class MemberListServiceImpl implements MemberListService {
	private static final Log log = LogFactory.getLog(MemberListServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public List<Member> memberList() {
		List<Member> list = mapper.selectAll();
		log.debug("service - memberList()"+list.size());
		return list;
	}

}
