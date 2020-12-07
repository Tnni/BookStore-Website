package kp.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.bean.UserBean;


@WebServlet(urlPatterns={"/login"})
public class Login extends Controller {

	private static final long serialVersionUID = 2020112301L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		if(null != g("ni") && null != g("pw") && g("ni").matches("^\\w{2,}$")){
			UserBean user = s.getUserByNickAndPwd(g("ni"), g("pw"));
			if(null != user){
				ss("user", user);
				//jsmsg("Login successfully", null==sg("url")?"./":sg("url").toString());
				resp.sendRedirect(null==sg("url")?"./":sg("url").toString());
				sr("url");
				return;
			}else{
				jsmsg("Login fail");
			}
		}
		show();
	}

}
