package com.graduate.DTO;

import java.sql.*;

public class CartDTO {
	private String userEmail; // 주문한 회원 이메일
	private String bookISBN; // 주문한 도서 ISBN
	private int cartPrice; // 카트에 담은 금액
	private Date cartDate; // 결제한 시각

	public CartDTO(String userEmail, String bookISBN, int cartPrice, Date cartDate) {
		super();
		this.userEmail = userEmail;
		this.bookISBN = bookISBN;
		this.cartPrice = cartPrice;
		this.cartDate = cartDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	@Override
	public String toString() {
		return "CartDTO [userEmail=" + userEmail + ", bookISBN=" + bookISBN + ", cartPrice=" + cartPrice + ", cartDate="
				+ cartDate + "]";
	}

}
