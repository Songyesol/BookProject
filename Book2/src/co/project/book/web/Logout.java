package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.project.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		request.setAttribute("memberId", memberId);
		
		session.invalidate();
		return "member/logoutSuccess";
	}

}
