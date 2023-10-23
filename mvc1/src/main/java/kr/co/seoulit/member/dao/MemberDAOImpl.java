package kr.co.seoulit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.seoulit.common.dao.DataAccessException;
import kr.co.seoulit.common.sl.ServiceLocator;
import kr.co.seoulit.member.to.MemberBean;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAOImpl instance;
	private MemberDAOImpl(){}
	public static MemberDAO getInstance(){
		if(instance==null) instance=new MemberDAOImpl();
		return instance;
	}

	public List<MemberBean> selectMemberList(){
		// TODO Auto-generated method stub
		List<MemberBean> v=new ArrayList<MemberBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("select * from member");

			DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberBean member=new MemberBean();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
				v.add(member);
			}
			return v;
		} catch(Exception sqle) {
			throw new DataAccessException(sqle.getMessage());			
		} finally {
			try{
				if(rs!=null){rs.close(); rs=null; }
				if(pstmt!=null){pstmt.close(); pstmt=null; }
				if(con!=null){con.close(); con=null; }
			}catch(Exception e){}		
		}
	}
	@Override
	public void insertMember(MemberBean member) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			StringBuffer query = new StringBuffer();
			query.append("insert into member values(?,?,?,?)");

			DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPw());
			pstmt.setString(3,member.getAddr());
			pstmt.setString(4,member.getTel());
			pstmt.executeUpdate();

		} catch(Exception sqle) {
			throw new DataAccessException(sqle.getMessage());			
		} finally {
			try{
				if(pstmt!=null){pstmt.close(); pstmt=null; }
				if(con!=null){con.close(); con=null; }
			}catch(Exception e){}		
		}		
	}
	@Override
	public MemberBean selectMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("select * from member where id=?");

			DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
			}
			return member;
		} catch(Exception sqle) {
			throw new DataAccessException(sqle.getMessage());			
		} finally {
			try{
				if(rs!=null){rs.close(); rs=null; }
				if(pstmt!=null){pstmt.close(); pstmt=null; }
				if(con!=null){con.close(); con=null; }
			}catch(Exception e){}		
		}
	}
}
