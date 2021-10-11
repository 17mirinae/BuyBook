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

	// 도서 추가하기
	public BookDTO addBook(BookDTO _bookDTO) {
		BookDTO bookDTO = bookDAO.selectByBookISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) { // 도서 존재하지 않음 --> 추가 진행
			bookDAO.addBook(_bookDTO);

			return _bookDTO; // 추가한 도서 반환
		} else {
			System.out.println("이미 존재하는 도서입니다.");

			return null;
		}
	}

	// 도서 삭제하기
	public void deleteBook(BookDTO _bookDTO) { // 도서 삭제
		BookDTO bookDTO = bookDAO.selectByBookISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) {
			System.out.println("존재하지 않는 도서입니다.");
		} else {
			bookDAO.deleteBook(bookDTO);
		}
	}

	// 도서 수정하기
//	public BookDTO updateBook(BookDTO _bookDTO) { // 도서 수정
//		BookDTO bookDTO = bookDAO.selectByBookISBN(_bookDTO.getBookISBN());
//
//		if (bookDTO == null) { // 도서 존재하지 않음
//			System.out.println("수정할 도서가 없습니다.");
//
//			return null;
//		} else { // 도서가 존재함
//			bookDAO.updateBook(_bookDTO);
//
//			return _bookDTO;
//		}
//	}

}
