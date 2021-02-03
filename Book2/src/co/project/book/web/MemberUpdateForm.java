package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class MemberUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 수정페이지 호출 (memberid 값 받아야함.)
		MemberVO vo=new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo = dao.selectMember(vo);
		request.setAttribute("vo", vo);
		String viewPage="member/memberUpdateForm";

		return viewPage;
	}

}
