package com.graduate.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.graduate.Service.BookService;
import com.graduate.DTO.BookDTO;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {

	@Autowired
	BookService bookService;

	// 도서 상세
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String bookDetail(Model model, @RequestParam String bookISBN) {
		BookDTO bookDTO = bookService.selectByBookISBN(bookISBN);

		List<BookDTO> genreBookList = bookService.selectGenreBookList(bookDTO.getBookISBN(), bookDTO.getBookGenre());

		model.addAttribute("");

		return "bookDetail";
	}

	// 도서 구매 페이지
	@RequestMapping(value = "/bookBuy", method = RequestMethod.GET)
	public String bookBuy() {
		return "bookBuy";
	}

}
