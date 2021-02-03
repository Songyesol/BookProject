package co.project.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.project.common.DAO;
import co.project.member.vo.MemberVO;

public class MemberDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;
	
	public ArrayList<MemberVO> selectMemberList(){
		ArrayList<MemberVO> list= new ArrayList<MemberVO>();
		MemberVO vo = new MemberVO();
		String sql = "SELECT * FROM MEMBER";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberTel(rs.getString("membertel"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
		
	}
	
	public MemberVO selectMember(MemberVO vo) {
		String sql = "SELECT  * FROM MEMBER WHERE MEMBERID=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs= psmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberTel(rs.getString("membertel"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
		
	}
	
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "SELECT  * FROM MEMBER WHERE MEMBERID=? AND MEMBERPASSWORD=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs= psmt.executeQuery();
			
			if(rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberName(rs.getString("membername"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
		
	}
	public int insertMember(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO MEMBER(MEMBERID,MEMBERNAME,MEMBERPASSWORD,MEMBERTEL,MEMBERADDRESS) VALUES(?,?,?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());
			
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
		
	}
	
	public int updateMember(MemberVO vo) {
		int n=0;
		String sql = "UPDATE MEMBER SET MEMBERTEL =?, MEMBERADDRESS=? WHERE MEMBERID = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberTel());
			psmt.setString(2, vo.getMemberAddress());
			psmt.setString(3, vo.getMemberId());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	

	public int deleteMember(MemberVO vo) {
		int n = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n=psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
		
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
