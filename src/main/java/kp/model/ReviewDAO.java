package kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import kp.bean.ReviewBean;
import kp.util.C3P0Util;

public class ReviewDAO {

	public ReviewDAO() throws Exception {
	}

	public List<ReviewBean> retrieveByBookId(int bid) throws SQLException{
		String query = "select * from kp_review where bid="+bid;
		query = "select a.*,b.nick from kp_review a left join kp_user b on b.uid=a.uid where a.bid="+bid;
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		List<ReviewBean> lr = new ArrayList<ReviewBean>();
		while (r.next()){
			ReviewBean bean = new ReviewBean(r.getInt(1), r.getInt(2), r.getInt(3), r.getDate(4), r.getString(5));
			bean.setAuthor(r.getString(6));
			lr.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return lr;	
	}

	public int insert(Integer bid, Integer uid, Date dates, String content
			)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_review (bid,uid,dates,content) values(?,?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setInt(1, bid);
		stmt.setInt(2, uid);
		stmt.setDate(3, new java.sql.Date(dates.getTime()));
		stmt.setString(4, content);

		return stmt.executeUpdate();
	}

	public int delete(String rid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_review where rid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, rid);
		return stmt.executeUpdate();
	}

}
