package kp.bean;

import java.util.Date;

public class OrderBean {
    private Integer oid;

    private Integer uid;

    private Date dates;

    private Boolean paid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

	public OrderBean(Integer oid, Integer uid, Date dates, Boolean paid) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.dates = dates;
		this.paid = paid;
	}

}