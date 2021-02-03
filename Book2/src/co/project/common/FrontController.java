package co.project.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.book.web.BoardList;
import co.project.book.web.BookDelete;
import co.project.book.web.BookInsert;
import co.project.book.web.BookInsertForm;
import co.project.book.web.BookRental;
import co.project.book.web.BookReturn;
import co.project.book.web.BookUpdate;
import co.project.book.web.BookUpdateForm;
import co.project.book.web.Login;
import co.project.book.web.Logout;
import co.project.book.web.MainCommand;
import co.project.book.web.Member;
import co.project.book.web.MemberDelete;
import co.project.book.web.MemberInsert;
import co.project.book.web.MemberInsertForm;
import co.project.book.web.MemberUpdate;
import co.project.book.web.MemberUpdateForm;
import co.project.book.web.NoRetalManage;
import co.project.book.web.RentalManage;
import co.project.book.web.UserBookList;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/login.do", new Login());
		map.put("/logout.do", new Logout());//로그아웃 세션 종료 
		map.put("/boardlist.do", new BoardList());
		map.put("/bookupdateform.do", new BookUpdateForm());
		map.put("/bookupdate.do", new BookUpdate());
		map.put("/member.do", new Member());
		map.put("/memberinsertform.do", new MemberInsertForm());
		map.put("/memberinsert.do" , new MemberInsert());
		map.put("/memberUpdateForm.do", new MemberUpdateForm());
		map.put("/memberUpdate.do", new MemberUpdate());
		map.put("/memberdelete.do", new MemberDelete());
		map.put("/bookdelete.do", new BookDelete());
		map.put("/bookinsertform.do", new BookInsertForm());
		map.put("/bookinsert.do", new BookInsert());
		map.put("/bookrental.do", new BookRental());
		map.put("/userBookList.do", new UserBookList());//내서재
		map.put("/bookReturn.do", new BookReturn()); //도서반납
		map.put("/rentalManage.do", new RentalManage());   
		map.put("/noretalManage.do", new NoRetalManage());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		Command command = map.get(path); 
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
