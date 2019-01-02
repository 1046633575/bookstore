package cn.itcast.bookstore.category.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;


public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService();
	
	/**
	 * 查询所有分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		req.setAttribute("categoryList", categoryService.findAll());
		return "f:/jsps/left.jsp";
	}
}
