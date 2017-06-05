package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.QingJia;

/**
 * Servlet implementation class updateqj2
 */
@WebServlet("/servlet/updateqj2")
public class updateqj2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateqj2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String cid,courseTime,ktype,redate,tid,content;
		int kid,isfu;
		kid=Integer.parseInt(request.getParameter("k_id"));
		//id=request.getParameter("id");
		cid=request.getParameter("cid");
		courseTime=request.getParameter("courseTime");
		ktype=request.getParameter("ktype");
		redate=request.getParameter("redate");
		tid=request.getParameter("tid");
		content=request.getParameter("content");
		isfu=Integer.parseInt(request.getParameter("isfu"));
		
		//if(hasExist(request,response,xuehao)==false){
			QingJia qj=new QingJia();
			qj.setKid(kid);
			qj.setCid(cid);
			//stu.setSex(sex);
			qj.setCourseTime(courseTime);
			qj.setKtype(ktype);
			qj.setRedate(redate);
			qj.setTid(tid);
			qj.setContent(content);
			qj.setIsfu(isfu);
			
			qj.updateQingJia2();
			out.print("学生修改成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/instructor/showQJ.jsp");
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
