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
 * Servlet implementation class delqj2
 */
@WebServlet("/servlet/delqj2")
public class delqj2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delqj2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);
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
		response.setCharacterEncoding("utf-8");
		boolean f;
		String message;
	    String k_id=request.getParameter("k_id");
	    QingJia qj=new QingJia();
	    
	    qj.deleteQingJia(k_id);
    
	    out.print("删除请假单成功，正在返回~~~");
		response.setHeader("refresh", "1.5;url=/stu_qj_ms/instructor/showQJ.jsp");
	}
	    /*f=stu.haslogin(s_id);
	    if(f==true){
	    	stu.deleteStudent(s_id);
	    	cou.deleteScore(s_id);
	    	message="删除成功！";
	    	doError(request,response,message);
	    }
	    else{
	    	message="您要删除的学生不存在！";
	    	doError(request,response,message);
	    }
	}
	public void doError(HttpServletRequest request,HttpServletResponse response,String str)
    throws ServletException, IOException{
        request.setAttribute("problem", str);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorpage.jsp");
        rd.forward(request, response);
    }*/

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
