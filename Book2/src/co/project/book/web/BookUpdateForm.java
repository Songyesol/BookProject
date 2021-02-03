package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.book.dao.BookDAO;
import co.project.book.vo.BookVO;
import co.project.common.Command;

public class BookUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		vo.setBookCode(request.getParameter("bId"));
		
		vo = dao.bookSelect(vo);
		request.setAttribute("vo", vo);
		
		return "board/bookUpdateForm";
	}

}
