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

	// 로그인
	@RequestMapping(value = "/user/signIn", method = RequestMethod.GET)
	public String userLogin() {
		return "userSignIn";
	}

	// 회원가입
	@RequestMapping(value = "/user/signUp", method = RequestMethod.GET)
	public String userRegister() {
		return "userSignUp";
	}
	
	// 각각의 아이템들의 세부사항
	@RequestMapping(value = "/item/", method = RequestMethod.GET)
	public String itemDetailPage() {
		return "itemDetail";
	}
}