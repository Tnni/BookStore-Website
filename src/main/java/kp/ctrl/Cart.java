package kp.ctrl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.BookBean;
import kp.bean.CartBean;


@WebServlet(urlPatterns={"/cart"})
public class Cart extends Controller {

	private static final long serialVersionUID = 2020112601L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		List<CartBean> cl = (List<CartBean>)sg("cart");
		if(null == cl)
			cl = new ArrayList<CartBean>();
		if(null == g("act")){
		}else if(g("act").equals("add") && null!=g("id") && g("id").matches("^[0-9]+$")){
			BookBean bb = s.getBookByBid(Integer.parseInt(g("id")));
			if(null != bb){
				long num = 1;
				if(null != g("num") && g("num").matches("^[0-9]+$"))
					num = Long.parseLong(g("num"));
				boolean exists = false;
				for(int i=0;i<cl.size();i++){
					if(cl.get(i).getBookId().equals(bb.getBid())){
						cl.get(i).setQuantity(cl.get(i).getQuantity() + (int)num);
						cl.get(i).setTotal(bb.getPrice().multiply(BigDecimal.valueOf(num)).add(cl.get(i).getTotal()));
						exists = true;
						break;
					}
				}
				if(!exists){
					CartBean cb = new CartBean(bb.getBid(),bb.getTitle(),bb.getImg(),(int)num,bb.getPrice(),bb.getPrice().multiply(BigDecimal.valueOf(num)));
					cl.add(cb);
				}
				ss("cart", cl);
			}
		}else if(g("act").equals("change") && null!=g("id") && g("id").matches("^[0-9]+$") && null!=g("num") && g("num").matches("^[0-9]+$")){
			BookBean bb = s.getBookByBid(Integer.parseInt(g("id")));
			if(null != bb){
				long num = Long.parseLong(g("num"));
				for(int i=0;i<cl.size();i++){
					if(cl.get(i).getBookId().equals(bb.getBid())){
						cl.get(i).setQuantity((int)num);
						cl.get(i).setTotal(bb.getPrice().multiply(BigDecimal.valueOf(num)));
						break;
					}
				}
				ss("cart", cl);
			}
		}else if(g("act").equals("delete") && null!=g("id") && g("id").matches("^[0-9]+$")){
			BookBean bb = s.getBookByBid(Integer.parseInt(g("id")));
			if(null != bb){
				for(int i=0;i<cl.size();i++){
					if(cl.get(i).getBookId().equals(bb.getBid())){
						cl.remove(i);
						break;
					}
				}
				ss("cart", cl);
			}
		}
		BigDecimal total = new BigDecimal(0);
		for(int i=0;i<cl.size();i++){
			total = total.add(cl.get(i).getTotal());
		}
		sa("subTotal", total);
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
