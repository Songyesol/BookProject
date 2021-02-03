package co.project.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 업데이트 내용 담아서 넘기기
		MemberVO vo = new MemberVO();
		MemberDAO dao =new MemberDAO();
		
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberId(request.getParameter("memberId"));
		
		
		int n=dao.updateMember(vo);
		String viewPage;
		if(n!=0) {
			viewPage = "member.do";
		}else {
			viewPage="member/memberUpdateFail";
		}
		return viewPage;
	}

}
