package com.graduate.Controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	// 메인
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		// ㅇ

		return "index";
	}

}