package kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import kp.bean.UserBean;
import kp.util.C3P0Util;

public class UserDAO {

	public UserDAO() throws Exception {
	}

	public Map<String, UserBean> retrieveByTitle(String title) throws SQLException{
		String query = "select * from kp_user where title like '%" + title +"%'";
		Map<String, UserBean> rv = new HashMap<String, UserBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()){
			UserBean bean = new UserBean(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getDate(6),r.getString(7),r.getString(8),r.getString(9));
			rv.put(r.getString(4), bean);//nick as key
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public UserBean retrieveByNick(String nick) throws SQLException{
		String query = "select * from kp_user where nick='" + nick +"'";
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		UserBean bean = null;
		if (r.next()){
			bean = new UserBean(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getDate(6),r.getString(7),r.getString(8),r.getString(9));
		}	
		r.close();
		p.close();
		con.close();
		return bean;	
	}

	public UserBean retrieveByNickAndPassword(String nick, String pswd) throws SQLException{
		String query = "select * from kp_user where nick='" + nick +"' and pass='" + pswd +"'";
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		UserBean bean = null;
		if (r.next()){
			bean = new UserBean(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getDate(6),r.getString(7),r.getString(8),r.getString(9));
		}	
		r.close();
		p.close();
		con.close();
		return bean;	
	}

	public int insert(String role, String email, String nick,
			String pass, Date dates, String name, String phone, String addr
			)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_user (role,email,nick,pass,dates,name,phone,addr) values(?,?,?,?,?,?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setString(1, role);
		stmt.setString(2, email);
		stmt.setString(3, nick);
		stmt.setString(4, pass);
		stmt.setDate(5, new java.sql.Date(dates.getTime()));
		stmt.setString(6, name);
		stmt.setString(7, phone);
		stmt.setString(8, addr);

		return stmt.executeUpdate();
	}

	public int delete(String uid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_user where uid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, uid);
		return stmt.executeUpdate();
	}

}
