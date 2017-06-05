package servlet;

import impl.PicDaoImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PicDao;
import entity.Pic;

/**
 * Servlet implementation class MyPics
 */
@WebServlet("/myPics")
public class MyPics extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PicDao picDao = new PicDaoImp();
		
		Pic pic = new Pic();
		List<Pic> list = new ArrayList<Pic>();
		String id = (String)request.getSession().getAttribute("id");

		
		try {
			
			list = picDao.findBySid(id);
		
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/student/myPics.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	}


