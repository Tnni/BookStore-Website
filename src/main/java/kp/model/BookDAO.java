package kp.model;

import java.math.BigDecimal;
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

import kp.bean.BookBean;
import kp.bean.ReportBean;
import kp.util.C3P0Util;

public class BookDAO {

	public BookDAO() throws Exception {
	}

	public BookBean retrieveByBookId(int bid) throws SQLException{
		BookBean bean = null;
		String query = "select * from kp_book where bid="+bid;
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()){
			bean = new BookBean(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4), r.getBigDecimal(5), r.getInt(6), r.getString(7), r.getString(8), r.getBigDecimal(9), r.getDate(10));
		}	
		r.close();
		p.close();
		con.close();
		return bean;	
	}

	public List<BookBean> retrieveByCid(int cid) throws SQLException{
		String query = "select * from kp_book where cid="+cid;
		List<BookBean> rv = new ArrayList<BookBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			BookBean bean = new BookBean(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4), r.getBigDecimal(5), r.getInt(6), r.getString(7), r.getString(8), r.getBigDecimal(9), r.getDate(10));
			rv.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public List<ReportBean> retrieveByMonth(String month) throws SQLException{
		String query = "select sum(num) as sold, bid, title from(select a.oid,a.dates,b.num,c.bid,c.title from kp_order a left join kp_order_item b on b.oid=a.oid left join kp_book c on c.bid=b.bid where c.bid is not null and a.dates>='"+month+"-01' and a.dates<='"+month+"-31') t group by bid";
		List<ReportBean> rv = new ArrayList<ReportBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			ReportBean bean = new ReportBean(r.getInt(1), r.getInt(2), r.getString(3));
			rv.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public List<ReportBean> retrieveTop10() throws SQLException{
		String query = "select sum(num) as sold, bid, title from(select a.oid,a.dates,b.num,c.bid,c.title from kp_order a left join kp_order_item b on b.oid=a.oid left join kp_book c on c.bid=b.bid where c.bid is not null) t group by bid order by sold desc limit 10";
		List<ReportBean> rv = new ArrayList<ReportBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			ReportBean bean = new ReportBean(r.getInt(1), r.getInt(2), r.getString(3));
			rv.add(bean);
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public Map<String, BookBean> retrieveByTitle(String title) throws SQLException{
		String query = "select * from kp_book where title like '%" + title +"%'";
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		Connection con = C3P0Util.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()){
			BookBean bean = new BookBean(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4), r.getBigDecimal(5), r.getInt(6), r.getString(7), r.getString(8), r.getBigDecimal(9), r.getDate(10));
			rv.put(r.getString(5), bean);//isbn as key
		}	
		r.close();
		p.close();
		con.close();
		return rv;	
	}

	public int rate(int bid, BigDecimal rate)throws SQLException, NamingException{
		String preparedStatement ="update kp_book set ranker=ranker+1,rank=? where bid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setBigDecimal(1, rate);
		stmt.setInt(2, bid);
		return stmt.executeUpdate();
	}

	public int insert(Integer cid, String title, String intro, BigDecimal rank, Integer ranker, String isbn, String img, BigDecimal price, Date dates
			)throws SQLException, NamingException {
		//note that the query parameters are set as ?
		String preparedStatement ="insert into kp_book values(?,?,?,?,?,?,?,?,?)";
		Connection con = C3P0Util.getConnection();
		//PreparedStatements prevent SQL injection
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		//here we set individual parameters through method calls
		//first parameter is the place holder position in the ? //pattern above
		stmt.setInt(1, cid);
		stmt.setString(2, title);
		stmt.setString(3, intro);
		stmt.setBigDecimal(4, rank);
		stmt.setInt(5, ranker);
		stmt.setString(6, isbn);
		stmt.setString(7, img);
		stmt.setBigDecimal(8, price);
		stmt.setDate(9, new java.sql.Date(dates.getTime()));

		return stmt.executeUpdate();
	}

	public int delete(String bid)throws SQLException, NamingException{
		String preparedStatement ="delete from kp_book where bid=?";
		Connection con = C3P0Util.getConnection();
		PreparedStatement stmt = con.prepareStatement(preparedStatement);
		stmt.setString(1, bid);
		return stmt.executeUpdate();
	}

}
