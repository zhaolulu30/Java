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
 * Servlet implementation class delteacher
 */
@WebServlet("/servlet/delteacher")
public class delteacher extends HttpServlet {
	public delteacher() {
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
		String tid;
		int fh;
		tid=request.getParameter("id");
		Teacher tea=new Teacher();
		fh=tea.deleteTeacher(tid);
		out.print("ɾ����ʦ�ɹ������ڷ��ء���");
		response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showteacher.jsp");
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
		String tid;
		int fh;
		tid=request.getParameter("id");
		Teacher tea=new Teacher();
		fh=tea.deleteTeacher(tid);
		out.print("ɾ����ʦ�ɹ������ڷ��ء���");
		response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showteacher.jsp");
		
		/*boolean f;
		String message;
	    String tid = request.getParameter("tid");
	    teacher tea=new teacher();
	    f=tea.isValid(tid);
	    if(f==true){
	    	tea.deleteTeacher(tid);
	    	message="ɾ���ɹ�������";
	    	doError(request,response,message);
	    }
	    else{
	    	message="�ý�ʦ�����ڣ�����";
	    	doError(request,response,message);
	    }	    	
 }

	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
            throws ServletException, IOException {
        request.setAttribute("problem", str);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
        rd.forward(request, response);*/
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
