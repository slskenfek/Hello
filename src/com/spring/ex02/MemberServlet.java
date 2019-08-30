package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//������������ ��û�� MemberDAO��ü�� �������� 
//MemberDAO��  selectName()�޼ҵ��
//selectPwd()�޼ҵ带 ȣ������ �� �����͸� ���������� �˸�â���� ����ϴ� ����
@WebServlet("/mem2.do")
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
		 
	  //String name = dao.selectName(); //MemberDAO�� selectName()�޼ҵ� ȣ��
		int pwd = dao.selectPwd();  //MemberDAO�� selectPwd()�޼ҵ� ȣ��
		
		
		PrintWriter out = response.getWriter();
		out.write("<script>");
	//	out.write("alert(' �̸�:" + name + "')");
		out.write("alert(' ��й�ȣ:" + pwd + "')");
		out.write("</script>");
		
	}	
	
}












