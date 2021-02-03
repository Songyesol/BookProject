package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.bookrental.dao.BookRentalDAO;
import co.project.bookrental.vo.BookRentalVO;
import co.project.common.Command;

public class BookRental implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 책빌리기
		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVO vo = new BookRentalVO();
		
		
		vo.setBookCode(request.getParameter("bookCode"));
		vo.setMemberId(request.getParameter("memberId"));
		int n = dao.insertRental(vo);
		
		String viewPage = null;
		
		if(n != 0) viewPage = "board/rentalSuccess";
		
		return viewPage;
	}

}
