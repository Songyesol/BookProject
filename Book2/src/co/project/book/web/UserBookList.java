package co.project.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.bookrental.dao.BookRentalDAO;
import co.project.bookrental.vo.BookRentalVO;
import co.project.common.Command;

public class UserBookList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 사용자가 빌린 책 list와 반납여부 선택화면
		
		
		BookRentalVO vo = new BookRentalVO();
		vo.setMemberId(request.getParameter("memberId"));
		
		 ArrayList<BookRentalVO> list = new ArrayList<BookRentalVO>();
		 
		 BookRentalDAO dao= new BookRentalDAO(); 
		 list = dao.userBookListForm(vo);
		 request.setAttribute("vo",vo); 
		 request.setAttribute("list", list);



		String viewPage = "board/userBookList";
		return viewPage;
	}

}
