package servlet;

import impl.QingJiaDaoImp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.QingJia;
import bean.QueryCondition;
import bean.QueryCondition1;
import dao.QingjiaDao;

/**
 * Servlet implementation class ExactqueryServlet
 */
@WebServlet("/exactquery")
public class ExactqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QingjiaDao qingjiaDao=new QingJiaDaoImp();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	
		int days = Integer.parseInt(request
				.getParameter("days"));
		String tid = (String)request.getSession().getAttribute("id");
		String redate=(String)request.getParameter("redate");
		QueryCondition condition = new QueryCondition();
		condition.setTid(tid);
		condition.setDays(days);
		condition.setRedate(redate);
		
		try {
			List<QingJia> qjList = qingjiaDao
					.findByCondition(condition);
			
			
			System.out.println(tid);
		    request.setAttribute("qjList", qjList);
			request.getRequestDispatcher("/qingjiaList.jsp").forward(request, response);
		} catch (Exception e) {
			    request.setAttribute("error", "Ã»ÓÐ¼ÇÂ¼");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	 
}
}
