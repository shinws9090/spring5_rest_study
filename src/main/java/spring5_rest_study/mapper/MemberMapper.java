package spring5_rest_study.mapper;

import java.util.List;

import spring5_rest_study.dto.Member;

public interface MemberMapper {
	Member selectById(Long id);
	List<Member> selectAll();
	int insert(Member member);
	int update(Member member);
	int delete(Long id);
}
