package kp.bean;

import java.util.Date;

public class ReviewBean {
    private Integer rid;

    private Integer bid;

    private Integer uid;

    private Date dates;

    private String content;

    private String author;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public ReviewBean(Integer rid, Integer bid, Integer uid, Date dates, String content) {
		super();
		this.rid = rid;
		this.bid = bid;
		this.uid = uid;
		this.dates = dates;
		this.content = content;
	}

}