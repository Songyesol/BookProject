package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberid"));
		vo.setMemberPassword(request.getParameter("memberpassword"));
		vo = dao.loginCheck(vo);
		
		String viewPage = null;
		if(vo.getMemberAuth() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberAuth", vo.getMemberAuth());
			session.setAttribute("memberName", vo.getMemberName());
			
			request.setAttribute("vo", vo);
			viewPage = "main.do";
		}else {
			viewPage="member/loginFail";
		}
			
		return viewPage;
	}

}
