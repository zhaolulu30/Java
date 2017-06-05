package servlet;

import impl.PicDaoImp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.PicDao;
import entity.Pic;

/**
 * Servlet implementation class UploadpicServlet
 */
@WebServlet("/uploadpic")
public class UploadpicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserDao userDao = new UserDaoImp();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PicDao picDao=new PicDaoImp();
		// 创建解析器的缺省配置
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		// 创建解析器
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		try {
			// 得到上传数据列表
			List<FileItem> items = sfu.parseRequest(request);
			System.out.println(items);
			
			// 获取第一项数据
			FileItem fileItem = items.get(0);
		
			// 获取上传文件名
			String fileName = fileItem.getName();
			Pic pic=new Pic();
			
			String id=(String)request.getSession().getAttribute("id");
			String teacher=request.getParameter("teacher");
			String instructor=request.getParameter("instructor");
			System.out.println(teacher);
			pic.setTid(teacher);
			pic.setTid(instructor);
			pic.setSid(id);
			System.out.println(id);
			
			System.out.println(fileName);
			
			// 获取存放下载文件目录的物理路径
			ServletContext context = getServletContext();
	
			String realPath = context.getRealPath("/upload");
			
			File f=new File(realPath);
			if (!f.exists()) {
				f.mkdir();
			}
			

			// 获取文件的扩展名
			String fileExt=(fileName.lastIndexOf('.')!=-1)?fileName.substring(fileName.lastIndexOf('.')):"";
			// 以 用户id_当前时间的毫秒值.文件扩展名 的形式重命名文件，此处假定用户id为1
			fileName="id_"+System.currentTimeMillis()+fileExt;
			// 创建待保存的目标文件File对象
			File file = new File(realPath + File.separator + fileName);
			pic.setFilename(fileName);
			picDao.add(pic);
			System.out.println("file:"+file);
			
			// 向硬盘写入文件
			fileItem.write(file);
			response.sendRedirect("myPics");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

      }
	}


