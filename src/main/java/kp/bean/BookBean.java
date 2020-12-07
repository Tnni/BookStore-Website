package kp.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class BookBean {
    private Integer bid;

	private Integer cid;

    @XmlElement
    private String title;

    private String intro;

    private BigDecimal rank;

    private Integer ranker;

    private String isbn;

    private String img;

    @XmlElement
    private BigDecimal price;

    private Date dates;

    public BookBean(Integer bid, Integer cid, String title, String intro, BigDecimal rank, Integer ranker,
    		String isbn, String img, BigDecimal price, Date dates) {
		super();
		this.bid = bid;
		this.cid = cid;
		this.title = title;
		this.intro = intro;
		this.rank = rank;
		this.ranker = ranker;
		this.isbn = isbn;
		this.price = price;
		this.dates = dates;
	}

    @XmlTransient
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @XmlTransient
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public BigDecimal getRank() {
        return rank;
    }

    public void setRank(BigDecimal rank) {
        this.rank = rank;
    }

    public Integer getRanker() {
		return ranker;
	}

	public void setRanker(Integer ranker) {
		this.ranker = ranker;
	}

	public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
}