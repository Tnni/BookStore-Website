package kp.bean;

import java.math.BigDecimal;

public class OrderItemBean {
    private Integer iid;

    private Integer oid;

    private Integer bid;

    private BigDecimal price;

    private Short num;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

	public OrderItemBean(Integer iid, Integer oid, Integer bid,
			BigDecimal price, Short num) {
		super();
		this.iid = iid;
		this.oid = oid;
		this.bid = bid;
		this.price = price;
		this.num = num;
	}

}