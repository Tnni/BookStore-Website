package kp.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="report")
public class ReportBean {
	private Integer sold;
	private Integer bid;
    private String title;

    public ReportBean() {
		super();
	}


    public ReportBean(Integer sold, Integer bid, String title) {
		super();
		this.bid = bid;
		this.sold = sold;
		this.title = title;
	}

    @XmlElement
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @XmlElement
    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}