package servlet;

import impl.PicDaoImp;
import impl.QingJiaDaoImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.QingJia;
import bean.Student;
import dao.PicDao;
import dao.QingjiaDao;
import entity.Pic;

/**
 * Servlet implementation class studentDetail
 */
@WebServlet("/studentDetail")
public class studentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		int kid=Integer.parseInt(request.getParameter("k_id"));
		String sid=request.getParameter("sid");
		QingJia qj=new QingJia();
		qj.setKid(kid);
		qj.setCid(sid);
		 PicDao picDao = new PicDaoImp();
			Pic pic = new Pic();
			List<Pic> list = new ArrayList<Pic>();
		
		try {
			  
			   list = picDao.findBySid(sid);
			   out.print(sid);
			   request.setAttribute("list", list);
			   request.getRequestDispatcher("/teacher/studentDetail.jsp").forward(request, response);
			} catch (Exception e) {
				   request.setAttribute("error", "Ò³Ãæ³ö´í");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				e.printStackTrace();
			}
		
		
	}

}
