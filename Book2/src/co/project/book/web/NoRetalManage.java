package co.project.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.bookrental.dao.BookRentalDAO;
import co.project.bookrental.vo.BookRentalVO;
import co.project.common.Command;

public class NoRetalManage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookRentalDAO dao = new BookRentalDAO();
		ArrayList<BookRentalVO> list= new ArrayList<BookRentalVO>();
		
		list=dao.rentalManageListForm();
		
		request.setAttribute("list", list);
		
		return "board/norentalBookList";
	}

}
