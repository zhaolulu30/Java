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
		// ������������ȱʡ����
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		// ����������
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		try {
			// �õ��ϴ������б�
			List<FileItem> items = sfu.parseRequest(request);
			System.out.println(items);
			
			// ��ȡ��һ������
			FileItem fileItem = items.get(0);
		
			// ��ȡ�ϴ��ļ���
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
			
			// ��ȡ��������ļ�Ŀ¼������·��
			ServletContext context = getServletContext();
	
			String realPath = context.getRealPath("/upload");
			
			File f=new File(realPath);
			if (!f.exists()) {
				f.mkdir();
			}
			

			// ��ȡ�ļ�����չ��
			String fileExt=(fileName.lastIndexOf('.')!=-1)?fileName.substring(fileName.lastIndexOf('.')):"";
			// �� �û�id_��ǰʱ��ĺ���ֵ.�ļ���չ�� ����ʽ�������ļ����˴��ٶ��û�idΪ1
			fileName="id_"+System.currentTimeMillis()+fileExt;
			// �����������Ŀ���ļ�File����
			File file = new File(realPath + File.separator + fileName);
			pic.setFilename(fileName);
			picDao.add(pic);
			System.out.println("file:"+file);
			
			// ��Ӳ��д���ļ�
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


