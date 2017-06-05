package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Teacher;

/**
 * Servlet implementation class addteacher
 */
@WebServlet("/servlet/addteacher")
public class addteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addteacher() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String t_id=request.getParameter("tid");
		String t_name=request.getParameter("tname");
		String password=request.getParameter("tpassword");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String office=request.getParameter("office");
		String c_id=request.getParameter("cid");
		String remark=request.getParameter("remark");
		
		Teacher tea=new Teacher();
		boolean f=tea.haslogin(t_id);
		if(f==true){
			message="对不起，该教工号号已被注册！";
			doError(request,response,message);
		}
		else if(t_id.equals("")){
			message="教工号号不能为空，请重新填写!";
			doError(request,response,message);
		}
		else if(t_name.equals("")){
			message="姓名不能为空，请重新填写！";
			doError(request,response,message);
		}
		else if(password.equals("")){
			message="密码不能为空，请重新填写！";
			doError(request,response,message);
		}
		else{
			tea.setId(t_id);
			tea.setTname(t_name);
			tea.setPassword(password);
			tea.setCid(c_id);
			tea.setSex(sex);
			tea.setAge(age);
			tea.setOffice(office);
			tea.setRemark(remark);
			tea.addTeacher();
			out.print("老师添加成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showteacher.jsp");
		}
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
