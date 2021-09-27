package com.graduate.Controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	// 메인
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		// 베스트셀러, 장르별 3권 추천, 신규 도서 모델

		return "index";
	}

}