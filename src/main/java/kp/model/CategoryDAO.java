package kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

import kp.bean.CategoryBean;
import kp.util.C3P0Util;

public class CategoryDAO {

	public CategoryDAO() throws Exception {
	}

	public CategoryBean retrieveByCid(int cid) throws SQLException{
		CategoryBean bean = null;
		String query = "select * from kp_category where cid="+cid;
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()){
			bean = new CategoryBean(r.getInt(1), r.getString(2));
		}	
		r.close();
		p.close();
		con.close();
		return bean;	
	}

	public List<CategoryBean> retrieveList() throws SQLException{
		String query = "select * from kp_category order by cid";
		List<CategoryBean> cl = new ArrayList<CategoryBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			CategoryBean bean = new CategoryBean(r.getInt(1), r.getString(2));
			cl.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return cl;	
	}

	public int insert(String name)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_category values(?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setString(1, name);

		return stmt.executeUpdate();
	}

	public int delete(String cid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_category where cid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, cid);
		return stmt.executeUpdate();
	}

}
