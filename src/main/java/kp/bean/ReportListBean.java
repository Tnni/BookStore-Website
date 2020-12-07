package kp.bean;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reportlist")
public class ReportListBean {

	@XmlElement(name="book")
	private java.util.List<ReportBean> List;

	public java.util.List<ReportBean> getList() {
		return List;
	}

	public void setList(java.util.List<ReportBean> list) {
		List = list;
	}

	 
    public Iterator<ReportBean> iterator(){
        return List.iterator();
    }

	public ReportListBean(java.util.List<ReportBean> list) {
		super();
		List = list;
	}

	public ReportListBean() {
		super();
		List = new ArrayList<ReportBean>();
	}

}