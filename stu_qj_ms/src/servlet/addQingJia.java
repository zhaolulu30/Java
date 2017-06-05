package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.QingJia;

/**
 * Servlet implementation class addQingJia
 */
@WebServlet("/servlet/addQingJia")
public class addQingJia extends HttpServlet {
	
		
		public addQingJia() {
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
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");

			String message;
			String kid=request.getParameter("kid");
			String sid=request.getParameter("sid");
			String course=request.getParameter("course");
			String courseTime=request.getParameter("courseTime");
			String ktype=request.getParameter("ktype");
			int days=Integer.parseInt(request.getParameter("days"));
			String redate=request.getParameter("redate");
			Date date=null;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			try {
				 date = format.parse(redate);

				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String teacher=request.getParameter("teacher");
			String instructor=request.getParameter("instructor");
			String content=request.getParameter("content");
			System.out.println(teacher);
			System.out.println(date);
			   System.out.println(format.format(date));
			QingJia qj=new QingJia();
			   
			   qj.setSid(sid);
				qj.setCid(course);
				qj.setCourseTime(courseTime);
				qj.setKtype(ktype);
				qj.setDays(days);
				qj.setRedate(format.format(date));
				qj.setTid(teacher);
				qj.setFid(instructor);
				qj.setContent(content);
				qj.addQingJia();
				message="Çë¼Ù³É¹¦£¡£¡£¡";
			  	doError(request,response,message);
				response.setHeader("refresh", "1.5;url=/stu_qj_ms/student/showsQJ.jsp");
		}
		
		public void doError(HttpServletRequest request,HttpServletResponse response,String str)
		throws ServletException,IOException{
			request.setAttribute("problem", str);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
	        rd.forward(request, response);
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

			doGet(request,response);
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
