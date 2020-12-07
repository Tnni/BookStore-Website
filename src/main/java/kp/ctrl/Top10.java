package kp.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.UserBean;


@WebServlet(urlPatterns={"/top10"})
public class Top10 extends Controller {

	private static final long serialVersionUID = 2020120301L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		UserBean ub = (UserBean)sg("user");
		if(null == ub || !ub.getRole().equals("administrator")){
			jsmsg("You must be administrator to view this page", "./");
		}else{
			sa("list", s.getTop10());
		}
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
