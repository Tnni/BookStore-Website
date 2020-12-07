package kp.bean;

import java.math.BigDecimal;

public class CartBean
{
	private Integer bookId;
	private String bookName;
	private String bookImg;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal total;

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public CartBean(Integer bookId, String bookName, String bookImg,
			Integer quantity, BigDecimal price, BigDecimal total) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

}