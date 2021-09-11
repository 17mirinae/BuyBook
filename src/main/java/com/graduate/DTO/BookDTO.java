package com.graduate.DTO;

public class BookDTO {
	private String bookISBN; // 도서 ISBN -- Primary Key
	private String bookTitle; // 도서 제목
	private String bookAuthor; // 도서 저자
	private int bookPrice; // 도서 금액
	private String bookGenre; // 도서 장르
	private String bookPublisher; // 도서 출판사
	private String bookImage; // 도서 이미지
	private int bookCount; // 도서 재고수
	private String bookSummary; // 도서 한 줄 줄거리

	public BookDTO(String bookISBN, String bookTitle, String bookAuthor, int bookPrice, String bookGenre,
			String bookPublisher, String bookImage, int bookCount, String bookSummary) {
		super();
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookGenre = bookGenre;
		this.bookPublisher = bookPublisher;
		this.bookImage = bookImage;
		this.bookCount = bookCount;
		this.bookSummary = bookSummary;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getBookSummary() {
		return bookSummary;
	}

	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}

}
