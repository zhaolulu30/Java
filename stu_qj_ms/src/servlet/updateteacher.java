package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;

/**
 * Servlet implementation class updateteacher
 */
@WebServlet("/servlet/updateteacher")
public class updateteacher extends HttpServlet {
	public updateteacher() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String tid,tname,password,sex,office,age,remark,cid;
		tid=request.getParameter("id");
		//id=request.getParameter("id");
		tname=request.getParameter("tname");
		password=request.getParameter("password");
		sex=request.getParameter("sex");
		age=request.getParameter("age");
		office=request.getParameter("office");
		cid=request.getParameter("cid");
		remark=request.getParameter("remark");
		//if(hasExist(request,response,xuehao)==false){
			Teacher tea=new Teacher();
			tea.setId(tid);
			tea.setTname(tname);
			tea.setPassword(password);
			tea.setSex(sex);
			tea.setAge(age);
			tea.setOffice(office);
			tea.setCid(cid);
			tea.setRemark(remark);
			tea.updateTeacher();
			out.print("��ʦ�޸ĳɹ������ڷ��أ����Ժ򡭡�");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showteacher.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
