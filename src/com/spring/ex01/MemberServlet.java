package com.spring.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//������������ ��û�� MemberDAO��ü�� �������� selectAllMemberList()�޼ҵ带 ȣ���ϴ� �����Դϴ�.
@WebServlet("/mem.do")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, 
            				HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberDAO dao  = new MemberDAO();//DB���� �۾��� ���� ��ü ����
		
		List membersList = dao.selectAllMemberList(); //��ȸ�� ������  List�� �����մϴ�.
		
		//��ȸ�� ������  request������ ���ε� �մϴ�.
		request.setAttribute("membersList", membersList);
		
		//��ȸ�� ������ ���ε��ϰ� JSP�������� ������ �մϴ�.
		RequestDispatcher dispatch = 
				request.getRequestDispatcher("test01/listMembers.jsp");
		
		dispatch.forward(request, response);
		
	}	
	
}












