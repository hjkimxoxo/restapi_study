package restfull_study.mapper;

import java.util.List;

import restfull_study.dto.Member;

public interface MemberMapper {
	List<Member> selectMemberByAll();
	Member selectMemberById(long id);
//	Member selectMemberByEmail(String email);
	int insertMember(Member member);
	int updateMember(Member member); 
	int deleteMember(long id);
}
