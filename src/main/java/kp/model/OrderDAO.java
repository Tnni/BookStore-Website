package kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import kp.bean.OrderBean;
import kp.util.C3P0Util;

public class OrderDAO {

	public OrderDAO() throws Exception {
	}

	public Map<String, OrderBean> retrieveById(int id) throws SQLException{
		String query = "select * from kp_order where oid="+id;
		Map<String, OrderBean> rv = new HashMap<String, OrderBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()){
			OrderBean bean = new OrderBean(r.getInt(1), r.getInt(2), r.getDate(3), r.getBoolean(4));
			rv.put(r.getString(1), bean);//order-id as key
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public int retrieveTotal() throws SQLException{
		int n = 0;
		String query = "select count(*) from kp_order";
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()){
			n = r.getInt(1);
		}	
		r.close();
		p.close();
		con.close();
		return n;	
	}

	public int insert(Integer uid, Date dates, Boolean paid
			)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_order values(?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setInt(1, uid);
		stmt.setDate(2, new java.sql.Date(dates.getTime()));
		stmt.setBoolean(3, paid);

		return stmt.executeUpdate();
	}

	public int insert2(Integer uid, Date dates, Boolean paid
			)throws SQLException, NamingException {
		int insertId = 0;
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_order (uid, dates, paid) values(?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setInt(1, uid);
		stmt.setDate(2, new java.sql.Date(dates.getTime()));
		stmt.setBoolean(3, paid);
		if(1 == stmt.executeUpdate()){
			stmt.close();
			PreparedStatement p = con.prepareStatement("select last_insert_id()");
			ResultSet r = p.executeQuery();
			if (r.next()){
				insertId = r.getInt(1);
			}	
			r.close();
			p.close();
		}
		con.close();
		return insertId;
	}

	public int delete(String oid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_order where oid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, oid);
		return stmt.executeUpdate();
	}

}
