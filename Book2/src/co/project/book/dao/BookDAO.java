package co.project.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.project.book.vo.BookVO;
import co.project.common.DAO;

public class BookDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;
	
	public ArrayList<BookVO> selectBookList(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOK";
		BookVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookVO();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookVO bookSelect(BookVO vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BookVO();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int bookInsert(BookVO vo) {
		int n = 0;
		String sql = "INSERT INTO BOOK VALUES('B'||LPAD(TO_CHAR(B_SEQ.NEXTVAL),3,0), ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getQuantity());
			psmt.setInt(3, vo.getQuantity());
			
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int bookUpdate(BookVO vo) {
		int n=0;
		String sql = "UPDATE BOOK SET BOOKNAME=?, QUANTITY=? WHERE BOOKCODE=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getQuantity());
			psmt.setString(3, vo.getBookCode());
			
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int bookDelete(BookVO vo) {
		int n=0;
		String sql = "DELETE FROM BOOK WHERE BOOKCODE=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
