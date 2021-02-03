package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.book.dao.BookDAO;
import co.project.book.vo.BookVO;
import co.project.common.Command;

public class BookInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		
		vo.setBookName(request.getParameter("bookName"));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		int n = dao.bookInsert(vo);
		
		String viewPage = null;
		if(n != 0) viewPage = "boardlist.do";
		
		return viewPage;
	}

}
