package com.graduate.Controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	// 도서 세부정보
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String bookDetail() {
		return "bookDetail";
	}
	
	//
}