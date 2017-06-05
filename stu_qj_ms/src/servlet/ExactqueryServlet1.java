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
 * Servlet implementation class ExactqueryServlet1
 */
@WebServlet("/exactquery1")
public class ExactqueryServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QingjiaDao qingjiaDao=new QingJiaDaoImp(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExactqueryServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String ktype=(String)request.getParameter("ktype");
		String redate=(String)request.getParameter("redate");
		QueryCondition1 condition1 = new QueryCondition1();
		condition1.setKtype(ktype);
		condition1.setRedate(redate);
		
		try {
			List<QingJia> qjList1 = qingjiaDao
					.findByCondition1(condition1);
			
			
			System.out.println(qjList1);
		    request.setAttribute("qjList1", qjList1);
			request.getRequestDispatcher("/instructor/qingjiaList.jsp").forward(request, response);
		} catch (Exception e) {
			    request.setAttribute("error", "Ã»ÓÐ¼ÇÂ¼");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	 
}
}

    