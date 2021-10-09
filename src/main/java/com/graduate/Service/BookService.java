package com.graduate.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

import com.graduate.DAO.BookDAO;
import com.graduate.DTO.BookDTO;

@Service
public class BookService {
	private BookDAO bookDAO;

	@Autowired
	public BookService(BookDAO _bookDAO) {
		this.bookDAO = _bookDAO;
	}

	// 모든 도서 목록 출력
	public List<BookDTO> showAll() {
		List<BookDTO> bookList = bookDAO.showAll();
		
		return bookList;
	}
	
	// ISBN 으로 도서 한 권 가져오기
	public BookDTO selectByBookISBN(String inputBookISBN) {
		BookDTO bookDTO = bookDAO.selectByBookISBN(inputBookISBN);
		
		return bookDTO;
	}

	// 도서 장르로 도서 가져오기
	public List<BookDTO> selectGenreBookList(String inputBookISBN, String inputBookGenre) {
		List<BookDTO> bookGenreList = bookDAO.selectGenreBookList(inputBookISBN, inputBookGenre);
		
		return bookGenreList;
	}

}
