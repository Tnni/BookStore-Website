package kp.ctrl;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.BookBean;


@WebServlet(urlPatterns={"/rate"})
public class Rate extends Controller {

	private static final long serialVersionUID = 2020112502L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		if(null != g("id") && g("id").matches("^[0-9]+$") && null != g("v") && g("v").matches("^[1-5](\\.[0-9])?$")){
			BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(g("v")));
			BookBean bb = s.getBookByBid(Integer.parseInt(g("id")));
			rate = bb.getRank().add(rate).divide(BigDecimal.valueOf(2.0));
			if(0 < s.rateBook(Integer.parseInt(g("id")), rate))
				out.print("{\"msg\":\"Rate Successfully\"}");
			else
				out.print("{\"msg\":\"Rate Fail\"}");
		}
	}

}
