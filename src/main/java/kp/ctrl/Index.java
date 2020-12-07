package kp.ctrl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.BookBean;
import kp.bean.CategoryBean;


@WebServlet(urlPatterns={"/index.jsp"})
public class Index extends Controller {

	private static final long serialVersionUID = 2020112201L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		//resp.getWriter().print("Index");
		List<CategoryBean> cl = s.getCategoryList();
		sa("catList", cl);
		int cat = 1;
		if(g("cat")!=null && g("cat").matches("^[123456]$"))
			cat = Integer.parseInt(g("cat"));
		List<BookBean> m = s.getBookListByCid(cat);
		sa("list", m);
		sa("cat", s.getCategoryByCid(cat));
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
