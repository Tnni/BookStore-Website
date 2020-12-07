package kp.model;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import kp.bean.BookBean;
import kp.bean.CategoryBean;
import kp.bean.ReportBean;
import kp.bean.ReportListBean;
import kp.bean.ReviewBean;
import kp.bean.UserBean;

import org.xml.sax.SAXException;

public class Models {

	private static Models s;
	public BookDAO bookDao;
	public CategoryDAO categoryDao;
	public OrderDAO orderDao;
	public OrderItemDAO orderItemDao;
	public ReviewDAO reviewDao;
	public UserDAO userDao;

	private Models() throws Exception {
		bookDao = new BookDAO();
		categoryDao = new CategoryDAO();
		orderDao = new OrderDAO();
		orderItemDao = new OrderItemDAO();
		reviewDao = new ReviewDAO();
		userDao = new UserDAO();
	}

	public static Models getInstance() throws Exception {
		if (s == null) {
			s = new Models();
		}
		return s;
	}

	public static boolean containsSqlInjection(Object obj) {
		Pattern pattern = Pattern
				.compile("\\b(and|exec|insert|select|drop|grant|alter|delete|update|count|chr|mid|master|"
						+ "truncate|char|declare|or)\\b|(\\*|;|\\+|'|%)");
		Matcher matcher = pattern.matcher(obj.toString());
		return matcher.find();
	}

	public CategoryBean getCategoryByCid(int cid){
		try {
			return categoryDao.retrieveByCid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<CategoryBean> getCategoryList() {
		try {
			return categoryDao.retrieveList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BookBean> getBookListByCid(Integer catid) {
		if (catid.getClass().getName() == "java.lang.Integer") {
			try {
				return bookDao.retrieveByCid(catid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public BookBean getBookByBid(Integer bookid) {
		if (bookid.getClass().getName() == "java.lang.Integer") {
			try {
				return bookDao.retrieveByBookId(bookid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<ReviewBean> getReviewByBookId(Integer bookid) {
		if (bookid.getClass().getName() == "java.lang.Integer") {
			try {
				return reviewDao.retrieveByBookId(bookid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int addUser(String role, String email, String nick, String pass, String name, String phone, String addr){
		try {
			userDao.insert(role, email, nick, pass, (new Date()), name, phone, addr);
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(e.getMessage().indexOf("uplicate entry") != -1)
				return 2;
			else
				e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public UserBean getUserByNick(String nick){
		try {
			return userDao.retrieveByNick(nick);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserBean getUserByNickAndPwd(String nick, String pwd){
		try {
			return userDao.retrieveByNickAndPassword(nick, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int saveOrder(Integer uid, Date dates, Boolean paid){
		try {
			return orderDao.insert2(uid, dates, paid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int getOrderAmount(){
		try {
			return orderDao.retrieveTotal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int saveOrderItem(int oid, int bid, BigDecimal price, Short num){
		try {
			return orderItemDao.insert(oid, bid, price, num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int rateBook(int bid, BigDecimal rate){
		int n = 0;
		try {
			n = bookDao.rate(bid, rate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	public int saveReview(int bid, int uid, String review){
		try {
			return reviewDao.insert(bid, uid, new Date(), review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String restReport(String month) throws JAXBException, SAXException, IOException, SQLException{
        // 首先创建 JAXBContext
        JAXBContext jContext = JAXBContext.newInstance(ReportListBean.class);
        // 初始化 Marshaller
        Marshaller marshaller = jContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        // 创建简单的 Java bean
		ReportListBean lrb = new ReportListBean(getReportByMonth(month));
        // 将结果输出到控制台
		StringWriter sw = new StringWriter();
		sw.write("\n");
		marshaller.marshal(lrb, new StreamResult(sw));

		return sw.toString();
	}

	public String restTop10() throws JAXBException, SAXException, IOException, SQLException{
        // 首先创建 JAXBContext
        JAXBContext jContext = JAXBContext.newInstance(ReportListBean.class);
        // 初始化 Marshaller
        Marshaller marshaller = jContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        // 创建简单的 Java bean
		ReportListBean lrb = new ReportListBean(getTop10());
        // 将结果输出到控制台
		StringWriter sw = new StringWriter();
		sw.write("\n");
		marshaller.marshal(lrb, new StreamResult(sw));

		return sw.toString();
	}

	public List<ReportBean> getReportByMonth(String month){
		try {
			return bookDao.retrieveByMonth(month);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ReportBean> getTop10(){
		try {
			return bookDao.retrieveTop10();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	public Map<String, BookBean> retriveStudent(String namePrefix, Integer mCT) throws Exception {
		if (namePrefix != null && mCT >= 0 && namePrefix.getClass().getName() == "java.lang.String"
				&& mCT.getClass().getName() == "java.lang.Integer") {
			if (containsSqlInjection(namePrefix)) {
				throw new Exception("Invalid name");
			} else {
				return sDAO.retrieve(namePrefix, mCT);
			}
		}
		return null;
	}

	public String export(String namePrefix, Integer mCT) throws Exception {
		Map<String, StudentBean> r = new HashMap<String, StudentBean>();
		r = retriveStudent(namePrefix, mCT);
		List<StudentBean> sb = new ArrayList<StudentBean>();

		for (Map.Entry<String, StudentBean> entry : r.entrySet()) {
			sb.add(new StudentBean(entry.getValue().getSid(), entry.getValue().getName(),
					entry.getValue().getCredit_taken(), entry.getValue().getCredit_graduate()));
		}

		ListWrapper lw = new ListWrapper(namePrefix, mCT, sb);
		JAXBContext jc = JAXBContext.newInstance(lw.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema sm = sf.newSchema(new File("SIS.xsd"));
		marshaller.setSchema(sm);

		StringWriter sw = new StringWriter();
		sw.write("\n");
		marshaller.marshal(lw, new StreamResult(sw));

		System.out.println(sw.toString()); // for debugging
		// return XML

		FileWriter fw = new FileWriter("D:\\Program Files\\EECS\\WORKPLACE\\SIS-v2\\WebContent\\SIS_Generated.xml");
		fw.write(sw.toString());
		fw.close();

		return sw.toString();
	}

	public int insert(String sid, String givenname, String surname, int credittake, int creditgraduate)
			throws SQLException, NamingException {
		if (givenname != null && surname != null && credittake >= 0 && creditgraduate >= 0
				&& givenname.getClass().getName() == "java.lang.String"
				&& surname.getClass().getName() == "java.lang.String"
				&& sid.matches("[0-9]+")) {
			if (containsSqlInjection(givenname) || containsSqlInjection(surname)) {
				return 0;
			} else {
				return sDAO.insert(sid, givenname, surname, credittake, creditgraduate);
			}
		}
		return 0;
	}

	public int delete(String sid) throws SQLException, NamingException {
		if (sid.matches("[0-9]+") && sid.length() > 2) {
			return sDAO.delete(sid);
		}
		return sDAO.delete(sid);
	}

	public String jsonPage(String namePrefix, Integer mCT) throws Exception {
		Map<String, BookBean> r = new HashMap<String, StudentBean>();
		r = retriveStudent(namePrefix, mCT);
		List<StudentBean> sb = new ArrayList<StudentBean>();

		for (Map.Entry<String, StudentBean> entry : r.entrySet()) {
			sb.add(new StudentBean(entry.getValue().getSid(), entry.getValue().getName(),
					entry.getValue().getCredit_taken(), entry.getValue().getCredit_graduate()));
		}
		JSONObject jo = new JSONObject();
		jo.put(namePrefix, sb);
		return jo.toString();
	}
	*/

}
