package kp.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.BookBean;
import kp.bean.ReviewBean;
import kp.bean.UserBean;


@WebServlet(urlPatterns={"/detail"})
public class Detail extends Controller {

	private static final long serialVersionUID = 2020112301L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		//resp.getWriter().print("Index");
		int bid = Integer.parseInt(req.getParameter("id"));
		BookBean obj = s.getBookByBid(bid);
		req.setAttribute("o", obj);
		List<ReviewBean> ol = s.getReviewByBookId(bid);
		req.setAttribute("ol", ol);
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		UserBean ub = (UserBean) sg("user");
		if(null == ub){
			jsmsg("You must login before writing reviews", "login");
			show();
			return;
		}
		if(g("rvw").length() > 1){
			s.saveReview(Integer.parseInt(g("bid")), ub.getUid(), g("rvw"));
			resp.sendRedirect("detail?id="+g("bid"));
		}
	}

}
