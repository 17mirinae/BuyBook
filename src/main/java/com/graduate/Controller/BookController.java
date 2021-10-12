package com.graduate.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import javax.servlet.http.*;

import com.graduate.Service.*;
import com.graduate.DTO.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	CartService cartService;

	// 도서 상세
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String bookDetail(Model model, @RequestParam String bookISBN) {
		BookDTO bookDTO = bookService.selectByBookISBN(bookISBN);
		// List<BookDTO> genreBookList =
		// bookService.selectGenreBookList(bookDTO.getBookISBN(),
		// bookDTO.getBookGenre());

		model.addAttribute("bookDTO", bookDTO);
		// model.addAttribute("genreBookList", genreBookList);

		return "bookDetail";
	}

	// 도서 장바구니 담기
	@PostMapping("/bookDetail")
	public void bookDetail(HttpSession session, @RequestParam String bookISBN, HttpServletResponse response)
			throws Exception {
		UserDTO userDTO = (UserDTO) session.getAttribute("userSessionDTO");
		BookDTO bookDTO = bookService.selectByBookISBN(bookISBN);

		CartDTO cartDTO = new CartDTO(userDTO.getUserEmail(), bookISBN, bookDTO.getBookImage(), bookDTO.getBookTitle(),
				1, bookDTO.getBookPrice());

		cartService.insertCart(cartDTO);

		response.sendRedirect("/book/bookDetail?bookISBN=" + bookISBN);// + "&bookGenre=" + bookDTO.getBookGenre());
	}

	// 도서 검색 페이지
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String bookSearch(Model model) {
		List<BookDTO> bookList = bookService.showAll();

		model.addAttribute("bookList", bookList);

		return "bookSearch";
	}

}
