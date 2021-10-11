package com.graduate.Controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.graduate.DTO.*;
import com.graduate.Service.*;
import com.graduate.Exception.*;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	@Autowired
	BookService bookService;

	// 관리자 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminIndex() {
		return "adminIndex";
	}

	// 도서 추가 페이지
	@RequestMapping(value = "/bookAdd", method = RequestMethod.GET)
	public String bookAdd(Model model) {
		List<BookDTO> bookList = bookService.showAll();

		model.addAttribute("bookList", bookList);

		return "bookAdd";
	}

	// 도서 추가 페이지
	@PostMapping(value = "/bookAdd")
	public void bookAdd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("inputBookImage") MultipartFile _inputBookImage) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookGenre = request.getParameter("inputBookGenre");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookAuthor = request.getParameter("inputBookAuthor");
			String inputBookPublisher = request.getParameter("inputBookPublisher");
			String inputBookCountString = request.getParameter("inputBookCount");
			String inputBookPrice = request.getParameter("inputBookPrice");
			String inputBookImage = null;
			///
			String inputBookSummary = request.getParameter("inputBookSummary").replaceAll("\r\n", "<br />");
			int inputBookHit = 0;

			int inputBookCount;

			BookDTO bookDTO = bookService.selectByBookISBN(inputBookISBN);

			if (bookDTO != null)
				throw new AlreadyExistingException("이미 존재하는 도서입니다.");

			if (!_inputBookImage.isEmpty()) {
				try {
					String uploadDir = "/bookImageStorage/";
					String realPathUpload = request.getServletContext().getRealPath(uploadDir);

					String fileName = _inputBookImage.getOriginalFilename();
					String filePath = realPathUpload + fileName;

					File files = new File(filePath);
					_inputBookImage.transferTo(files);

					inputBookImage = fileName;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			if (inputBookISBN.equals("") || inputBookGenre.equals("") || inputBookTitle.equals("")
					|| inputBookAuthor.equals("") || inputBookPublisher.equals("") || inputBookPrice.equals(""))
				throw new FillOutInformationException("모든 정보를 입력해주세요.");

			if (inputBookCountString.equals(""))
				inputBookCount = 1;
			else
				inputBookCount = Integer.parseInt(inputBookCountString);

			bookDTO = new BookDTO(inputBookISBN, inputBookTitle, inputBookAuthor, Integer.parseInt(inputBookPrice),
					inputBookGenre, inputBookPublisher, inputBookImage, inputBookCount, inputBookSummary);

			bookDTO = bookService.addBook(bookDTO);

			System.out.println(bookDTO.toString());

			response.sendRedirect("/admin/book/add");
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 도서입니다.'); location.href='/admin/bookAdd';</script>");

			out.flush();
		} catch (FillOutInformationException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('모든 정보를 입력해주세요.'); location.href='/admin/bookAdd';</script>");

			out.flush();
		}
	}
}
