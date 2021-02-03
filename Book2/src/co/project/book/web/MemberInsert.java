package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId2"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		int n = dao.insertMember(vo);
		String viewPage= null;
		if(n != 0) {
			viewPage = "main.do";
		}else {
			viewPage ="member/insertFail";
		}
		
		
		return viewPage;
	}

}
