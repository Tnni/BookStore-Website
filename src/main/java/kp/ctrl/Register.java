package kp.ctrl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/register"})
public class Register extends Controller {

	private static final long serialVersionUID = 2020112301L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		if(sg("user") != null){
			jsmsg("You have signed up already!", "./");
		}
		show();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		if(g("su") != null){
			if(!g("pw").equals(g("pw2"))){
				jsmsg("Two passwords not match!");
				show();
				return;
			}
			if(!g("ni").matches("^\\w{2,}$")){
				jsmsg("Invalid username!");
				show();
				return;
			}
			int code = s.addUser("user", g("em"), g("ni"), g("pw"), g("na"), g("ph"), g("ad"));
			if(0 == code){
				jsmsg("Sign up successfully!", "login");
			}else if(2 == code){
				jsmsg("Username exists already!");
			}else{
				jsmsg("Sign Up Fail!");
			}
		}
		show();
	}

}
