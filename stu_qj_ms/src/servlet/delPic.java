package servlet;

import impl.PicDaoImp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PicDao;

/**
 * Servlet implementation class delPic
 */
@WebServlet("/delPic")
public class delPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delPic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PicDao picDao=new PicDaoImp();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			picDao.delete(id);
			request.setAttribute("success", "É¾³ý³É¹¦");
			request.getRequestDispatcher("myPics").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}