package co.project.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.book.dao.BookDAO;
import co.project.book.vo.BookVO;
import co.project.common.Command;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		list = dao.selectBookList();
		request.setAttribute("list", list);
		return "board/boardList";
	}

}
