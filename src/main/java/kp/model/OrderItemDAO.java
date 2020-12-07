package kp.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import kp.bean.OrderItemBean;
import kp.util.C3P0Util;

public class OrderItemDAO {

	public OrderItemDAO() throws Exception {
	}

	public Map<String, OrderItemBean> retrieveById(int id) throws SQLException{
		String query = "select * from kp_order_item where oid="+id;
		Map<String, OrderItemBean> rv = new HashMap<String, OrderItemBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()){
			OrderItemBean bean = new OrderItemBean(r.getInt(1), r.getInt(2), r.getInt(3), r.getBigDecimal(4), r.getShort(5));
			rv.put(r.getString(1), bean);//primary-id as key
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public List<OrderItemBean> retrieveListByOrderId(int orderId) throws SQLException{
		String query = "select * from kp_order_item where oid="+orderId;
		List<OrderItemBean> oil = new ArrayList<OrderItemBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			OrderItemBean bean = new OrderItemBean(r.getInt(1), r.getInt(2), r.getInt(3), r.getBigDecimal(4), r.getShort(5));
			oil.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return oil;	
	}

	public int insert(Integer oid, Integer bid, BigDecimal price, Short num
			)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_order_item (oid,bid,price,num) values(?,?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setInt(1, oid);
		stmt.setInt(2, bid);
		stmt.setBigDecimal(3, price);
		stmt.setShort(4, num);

		return stmt.executeUpdate();
	}

	public int delete(String iid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_order_item where iid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, iid);
		return stmt.executeUpdate();
	}

}
