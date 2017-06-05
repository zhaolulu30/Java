package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sqlBean;

/**
 * Servlet implementation class updateIpassword
 */
@WebServlet("/servlet/updateIpassword")
public class updateIpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateIpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");
			String i_id=request.getParameter("id");
			String i_password=request.getParameter("password");
			String old;
			String pw1=null;
			String pw2=null;
			old=request.getParameter("oldpassword");
			pw1=request.getParameter("password1");
			pw2=request.getParameter("password2");
			if(!old.equals(i_password)&!old.equals(""))
				doError(request,response,"原始密码错误");
			else if(pw1.equals("")&pw2.equals(""))
				doError(request,response,"密码不能为空！");
			else if(!pw1.equals(pw2)&!old.equals(""))
				doError(request,response,"密码不一致，请重新输入！");
			else{
				String sql="update instructor set password='"+pw1+"'where id='"+i_id+"'";
				sqlBean db=new sqlBean();
				db.executeInsert(sql);				
				doError(request,response,"您的密码修改成功！！！");
			}	
		}
		public void doError(HttpServletRequest request,HttpServletResponse response,String str)
		throws ServletException,IOException{
			request.setAttribute("problem", str);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/errorpage.jsp");
			rd.forward(request, response);
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
