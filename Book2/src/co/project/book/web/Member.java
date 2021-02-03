package co.project.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.common.Command;
import co.project.member.dao.MemberDAO;
import co.project.member.vo.MemberVO;

public class Member implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.selectMemberList();
		
		request.setAttribute("list", list);
		
		return "member/memberList";
	}

}
