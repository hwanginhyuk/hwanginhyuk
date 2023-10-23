package kr.co.seoulit.member.sf;

import java.util.List;
import kr.co.seoulit.member.dao.MemberDAOImpl;
import kr.co.seoulit.member.to.MemberBean;

public class MemberServiceFacadeImpl implements MemberServiceFacade{
	private static MemberServiceFacade instance=new MemberServiceFacadeImpl();
	public static MemberServiceFacade getInstance(){
		return instance;
	}
	@Override
	public List<MemberBean> getMemberList() {
		// TODO Auto-generated method stub
		return MemberDAOImpl.getInstance().selectMemberList();
	}
	@Override
	public void addMember(MemberBean member) {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().insertMember(member);		
	}
	@Override
	public MemberBean getMember(String id) {
		// TODO Auto-generated method stub
		return MemberDAOImpl.getInstance().selectMember(id);
	}
}
