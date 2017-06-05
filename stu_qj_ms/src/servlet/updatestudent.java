package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

/**
 * Servlet implementation class updatestudent
 */
@WebServlet("/servlet/updatestudent")
public class updatestudent extends HttpServlet {
	public updatestudent() {
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
		String sid,sname,sex,sclass,password;
		sid=request.getParameter("sid");
		//id=request.getParameter("id");
		sname=request.getParameter("sname");
		sex=request.getParameter("sex");
		sclass=request.getParameter("sclass");
		password=request.getParameter("password");
		//if(hasExist(request,response,xuehao)==false){
			Student stu=new Student();
			stu.setSid(sid);
			stu.setSname(sname);
			//stu.setSex(sex);
			stu.setSex(sex);
			stu.setSclass(sclass);
			stu.setPassword(password);
			stu.updateStudent();
			out.print("学生修改成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showstudent.jsp");
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String sid,sname,sex,sclass,password;
		sid=request.getParameter("sid");
		//id=request.getParameter("id");
		sname=request.getParameter("sname");
		sex=request.getParameter("sex");
		sclass=request.getParameter("sclass");
		password=request.getParameter("password");
		//if(hasExist(request,response,xuehao)==false){
			Student stu=new Student();
			stu.setSid(sid);
			stu.setSname(sname);
			//stu.setSex(sex);
			stu.setSex(sex);
			stu.setSclass(sclass);
			stu.setPassword(password);
			stu.updateStudent();
			out.print("学生修改成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showstudent.jsp");
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
