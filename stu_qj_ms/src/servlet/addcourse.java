package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import bean.Teacher;

/**
 * Servlet implementation class addcourse
 */
@WebServlet("/servlet/addcourse")
public class addcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		double credit;
		
		boolean f;
		String c_id=request.getParameter("cid");
		String c_name=request.getParameter("cname");
		credit=Double.parseDouble((request.getParameter("credit")));
		
		Course co=new Course();
		f=co.isValid(c_id);
		if(f==false){
			co.setCid(c_id);
			co.setCname(c_name);
			co.setCredit(credit);
			
			co.addCourse();
			out.print("课程添加成功！正在返回，请稍候……");
			response.setHeader("refresh", "1.5;url=/stu_qj_ms/manager/showcourse.jsp");
		}
		else{
			String message="对不起，您要添加的课程号已存在！";
			doError(request,response,message);
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
