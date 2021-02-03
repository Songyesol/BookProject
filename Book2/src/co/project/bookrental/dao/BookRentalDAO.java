package co.project.bookrental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.project.bookrental.vo.BookRentalVO;
import co.project.common.DAO;

public class BookRentalDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;
	
	public ArrayList<BookRentalVO> selectRentalList(){
		ArrayList<BookRentalVO> rentalList = new ArrayList<BookRentalVO>();
		BookRentalVO rvo= new BookRentalVO();
		String sql = "SELECT * FROM BOOKRENTAL";
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				rvo.setRentalDate(rs.getDate("rentaldate"));
				rvo.setBookCode(rs.getString("bookcode"));
				rvo.setMemberId(rs.getString("memberid"));
				rvo.setReturnDate(rs.getDate("returndate"));
				rentalList.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return rentalList;
		
	}
	
	public int insertRental(BookRentalVO rvo) {
		int n=0;
		String sql = "INSERT INTO BOOKRENTAL(BOOKCODE,MEMBERID,rentalnumber) VALUES(?,?,RETAL_NUM_SEQ.nextval)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, rvo.getBookCode());
			psmt.setString(2, rvo.getMemberId());		
			
			n=psmt.executeUpdate();
			bCount(rvo.getBookCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	public int returnRental(BookRentalVO rvo) {
		int n=0;
		String sql = "UPDATE BOOKRENTAL SET RETURNDATE = SYSDATE WHERE RENTALNUMBER =? AND MEMBERID=? AND BOOKCODE=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, rvo.getRentalNumber());
			psmt.setString(2, rvo.getMemberId());
			psmt.setString(3, rvo.getBookCode());;
			
			n=psmt.executeUpdate();
			bookCount(rvo.getBookCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	public ArrayList<BookRentalVO> rentalManageListForm(){
	      ArrayList<BookRentalVO> list = new ArrayList<BookRentalVO>();
	      BookRentalVO rvo;
	      String sql = "SELECT R.RENTALNUMBER, R.MEMBERID, r.BOOKCODE, B.BOOKNAME , R.RENTALDATE, R.RETURNDATE  FROM BOOK B JOIN BOOKRENTAL R ON(B.BOOKCODE = R.BOOKCODE) ORDER BY R.RETURNDATE DESC";
	      try {
	         psmt=conn.prepareStatement(sql);
	         rs=psmt.executeQuery();
	         
	         while(rs.next()) {
	            rvo=new BookRentalVO();
	            rvo.setRentalNumber(rs.getInt("rentalnumber"));
	            rvo.setMemberId(rs.getString("memberid"));
	            rvo.setBookCode(rs.getString("bookcode"));
	            rvo.setBookName(rs.getString("bookName"));
	            rvo.setRentalDate(rs.getDate("rentaldate"));
	            rvo.setReturnDate(rs.getDate("returndate"));
	            list.add(rvo);
	         }
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      
	      return list;
	}
	
	private void bCount(String count) {
		String sql ="UPDATE BOOK SET BCOUNT=BCOUNT-1 WHERE BOOKCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, count);
			
			int n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void bookCount(String count) {
	      String sql ="UPDATE BOOK SET BCOUNT=BCOUNT+1 WHERE BOOKCODE=?";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, count);
	         
	         int n = psmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	
	
	//회원 내서재 조회
	
	public ArrayList<BookRentalVO> userBookListForm(BookRentalVO vo){
		ArrayList<BookRentalVO> list = new ArrayList<BookRentalVO>();

		String sql = "select r.rentalnumber, b.bookcode, b.bookname, r.rentaldate, r.returndate "
				+ " from book b join bookrental r "
				+ "on(b.bookcode = r.bookcode) where r.memberid= ?  ORDER BY R.RETURNDATE DESC NULLS FIRST ";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo=new BookRentalVO();
				vo.setRentalNumber(rs.getInt("rentalnumber"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookName"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setReturnDate(rs.getDate("returndate"));
				list.add(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
