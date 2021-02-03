package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.bookrental.dao.BookRentalDAO;
import co.project.bookrental.vo.BookRentalVO;
import co.project.common.Command;

public class BookReturn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 책 반납 
		BookRentalDAO dao= new BookRentalDAO();
		BookRentalVO vo =new BookRentalVO();
		int n=0;
		vo.setRentalNumber(Integer.parseInt(request.getParameter("rentalNumber")));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setBookCode(request.getParameter("bookCode"));
		 n=dao.returnRental(vo);
		 
		 String viewPage=null;
		 if(n != 0) {
			 viewPage="board/returnSuccess";
		 } else {
			 viewPage="board/returnFail";
		 }
		return viewPage;
	}

}
