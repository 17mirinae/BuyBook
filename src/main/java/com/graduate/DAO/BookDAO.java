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

	public BookDTO selectByBookISBN(String inputBookISBN) {
		// 한 권의 도서 조회
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE BOOKISBN='" + inputBookISBN + "';",
					(rs, getrowNum) -> new BookDTO(rs.getString("BOOKISBN"), rs.getString("BOOKTITLE"),
							rs.getString("BOOKAUTHOR"), rs.getInt("BOOKPRICE"), rs.getString("BOOKGENRE"),
							rs.getString("BOOKPUBLISHER"), rs.getString("BOOKIMAGE"), rs.getInt("BOOKCOUNT"),
							rs.getString("BOOKSUMMARY")),
					inputBookISBN);
		} catch (Exception ex) {
			return null;
		}
	}
	
	public List<BookDTO> selectGenreBookList() {
		List<BookDTO> result = null;
		return result;
	}
}
