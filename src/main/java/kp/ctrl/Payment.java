package kp.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.CartBean;
import kp.bean.UserBean;


@WebServlet(urlPatterns={"/payment"})
public class Payment extends Controller {

	private static final long serialVersionUID = 2020112503L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		if(null == sg("user")){
			ss("url", "payment");
			jsmsg("You did not login or signup", "register");
			//resp.sendRedirect("register");			return;
		}
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		if(null != g("card")){
			UserBean ub = (UserBean)sg("user");
			int n = s.getOrderAmount();
			boolean paid = n % 3 == 2 ? false : true;// every 3rd request is denied
			if(paid){
				//save order
				n = s.saveOrder(ub.getUid(), new Date(), paid);
				//save order items
				List<CartBean> cl = (List<CartBean>)sg("cart");
				for(int i=0;i<cl.size();i++)
					s.saveOrderItem(n, cl.get(i).getBookId(), cl.get(i).getPrice(), cl.get(i).getQuantity().shortValue());
				ss("cart", new ArrayList<CartBean>());// reset cart
				jsmsg("Order Successfully Completed.", "./");
			}else{
				//save empty order to occupy 3rd
				n = s.saveOrder(0, new Date(), paid);
				jsmsg("Credit Card Authorization Failed.");
			}
			show();
		}
	}

}
