package com.graduate.DAO;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graduate.DTO.BookDTO;

@Component
public class BookDAO {
	private BookDTO bookDTO;
	private JdbcTemplate jdbcTemplate;

	public BookDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 한 권의 도서 조회
	public BookDTO selectByBookISBN(String inputBookISBN) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE BOOKISBN = '" + inputBookISBN + "';",
					(rs, getrowNum) -> new BookDTO(rs.getString("BOOKISBN"), rs.getString("BOOKTITLE"),
							rs.getString("BOOKAUTHOR"), rs.getInt("BOOKPRICE"), rs.getString("BOOKGENRE"),
							rs.getString("BOOKPUBLISHER"), rs.getString("BOOKIMAGE"), rs.getInt("BOOKCOUNT"),
							rs.getString("BOOKSUMMARY"), rs.getDate("BOOKDATE")),
					inputBookISBN);
		} catch (Exception ex) {
			return null;
		}
	}

	// 현재 조회 중인 책을 제외한 동일 장르의 도서 목록
	public List<BookDTO> selectGenreBookList(String inputBookISBN, String inputBookGenre) {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK WHERE BOOKISBN != '" + inputBookISBN
				+ "' AND BOOKGENRE = '" + inputBookGenre + "' ORDER BY RAND() LIMIT 4;", (rs, rowNum) -> {
					BookDTO bookDTO = new BookDTO(rs.getString("BOOKISBN"), rs.getString("BOOKTITLE"),
							rs.getString("BOOKAUTHOR"), rs.getInt("BOOKPRICE"), rs.getString("BOOKGENRE"),
							rs.getString("BOOKPUBLISHER"), rs.getString("BOOKIMAGE"), rs.getInt("BOOKCOUNT"),
							rs.getString("BOOKSUMMARY"), rs.getDate("BOOKDATE"));
					return bookDTO;
				});

		return result;
	}

	// 신작 도서 10권 목록
	public List<BookDTO> newBookList() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("BOOKISBN"), rs.getString("BOOKTITLE"),
					rs.getString("BOOKAUTHOR"), rs.getInt("BOOKPRICE"), rs.getString("BOOKGENRE"),
					rs.getString("BOOKPUBLISHER"), rs.getString("BOOKIMAGE"), rs.getInt("BOOKCOUNT"),
					rs.getString("BOOKSUMMARY"), rs.getDate("BOOKDATE"));
			return bookDTO;
		});

		return result;
	}

	// 모든 도서 목록 조회
	public List<BookDTO> showAll() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("BOOKISBN"), rs.getString("BOOKTITLE"),
					rs.getString("BOOKAUTHOR"), rs.getInt("BOOKPRICE"), rs.getString("BOOKGENRE"),
					rs.getString("BOOKPUBLISHER"), rs.getString("BOOKIMAGE"), rs.getInt("BOOKCOUNT"),
					rs.getString("BOOKSUMMARY"), rs.getDate("BOOKDATE"));
			return bookDTO;
		});

		return result;
	}

	// 도서 추가
	public void insertBook(BookDTO bookDTO) {
		jdbcTemplate.update(
				"INSERT INTO BOOK(BOOKISBN, BOOKTITLE, BOOKAUTHOR, BOOKPRICE, BOOKGENRE, BOOKPUBLISHER, BOOKIMAGE, BOOKCOUNT, BOOKSUMMARY, BOOKDATE) VALUES('"
						+ bookDTO.getBookISBN() + "', '" + bookDTO.getBookTitle() + "', '" + bookDTO.getBookAuthor()
						+ "', '" + bookDTO.getBookPrice() + "', '" + bookDTO.getBookGenre() + "', '"
						+ bookDTO.getBookPublisher() + "', '" + bookDTO.getBookImage() + "', '" + bookDTO.getBookCount()
						+ "', '" + bookDTO.getBookSummary() + "', NOW());");
	}
}