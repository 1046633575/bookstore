package cn.itcast.bookstore.order;

import cn.itcast.bookstore.book.domain.Book;

public class OrderItem {
	private String iid;
	private int count;//数量
	private double subtotal;//小计
	private Order order;//所属订单
	private Book book;//所要购买的图书 
	
	public String getIid() {
		return iid;
	}
	
	public void setIid(String iid) {
		this.iid = iid;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
}
