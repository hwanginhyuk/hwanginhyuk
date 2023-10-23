package kr.co.seoulit.member.dao;

import java.util.List;
import kr.co.seoulit.common.dao.DataAccessException;
import kr.co.seoulit.member.to.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMemberList() throws DataAccessException ;
	public MemberBean selectMember(String id) throws DataAccessException ;
	public void insertMember(MemberBean member) throws DataAccessException ;
}
