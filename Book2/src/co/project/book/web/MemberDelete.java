package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("row"));
		int n = dao.deleteMember(vo);
		String viewPage = null;
		if(n != 0) viewPage = "member.do";
		return viewPage;
	}

}
