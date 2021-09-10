package com.graduate.Controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {
	// 회원가입
	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
	public String userSignUp() {
		return "userSignUp";
	}

	// 회원 수정
	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
	public String userUpdate() {
		return "userUpdate";
	}

	// 로그인
	@RequestMapping(value = "/userSignIn", method = RequestMethod.GET)
	public String userSignIn() {
		return "userSignIn";
	}
}
