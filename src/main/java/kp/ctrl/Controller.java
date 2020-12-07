package kp.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kp.model.Models;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 2020112201L;
	protected HttpServletRequest req = null;
	protected HttpServletResponse res = null;
	protected PrintWriter out = null;
	protected static Models s;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		try {
			s = Models.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.req = request;
		this.res = response;
		this.out = response.getWriter();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		try {
			s = Models.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.req = request;
		this.res = response;
		this.out = response.getWriter();
	}

	protected void show(String pageName){
		try {
			//debug(getServletName().substring(getServletName().lastIndexOf('.')+1).toLowerCase());
			req.getRequestDispatcher("/WEB-INF/template/"+pageName+".jsp").forward(req,res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("Error occured: "+e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("Error occured: "+e.getLocalizedMessage());
		}
	}

	protected void show(){
		try {
			req.getRequestDispatcher("/WEB-INF/template/"+getServletName().substring(getServletName().lastIndexOf('.')+1).toLowerCase()+".jsp").forward(req,res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("Error occured: "+e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("Error occured: "+e.getLocalizedMessage());
		}
	}

	/**
	 * [Alias] request.getParameter
	 * @param para
	 * @return
	 */
	protected String g(String para){
		return req.getParameter(para);
	}

	/**
	 * [Alias] request.setAttribute
	 * @param key
	 * @param val
	 */
	protected void sa(String key, Object val){
		req.setAttribute(key, val);
	}

	/**
	 * [Alias] getSession().setAttribute
	 * @param key
	 * @param val
	 */
	protected void ss(String key, Object val){
		req.getSession().setAttribute(key, val);
	}

	/**
	 * [Alias] getSession().getAttribute
	 * @param key
	 * @param val
	 */
	protected Object sg(String key){
		return req.getSession().getAttribute(key);
	}

	/**
	 * [Alias] getSession().removeAttribute
	 * @param key
	 */
	protected void sr(String key){
		req.getSession().removeAttribute(key);
	}

	protected void debug(Object o){
		System.out.println(o);
	}

	/**
	 * JavaScript alert(msg)
	 * @param msg
	 */
	protected void jsmsg(String msg){
		sa("jsMsg", msg);
	}

	/**
	 * JavaScript alert(msg) then redirect to url
	 * @param msg
	 */
	protected void jsmsg(String msg, String url){
		sa("jsMsg", msg);
		sa("jsUrl", url);
	}

}
