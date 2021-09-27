package com.graduate.Controller;

import java.io.PrintWriter;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.graduate.Service.*;
import com.graduate.DTO.*;
import com.graduate.Exception.*;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

	@Autowired
	UserService userService;

	// 회원가입
	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
	public String userSignUp() {
		return "userSignUp";
	}

	// 회원가입
	@PostMapping(value = "/userSignUp")
	public void userSignUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputUserEmail = request.getParameter("inputUserEmail");
			String inputUserPwd = request.getParameter("inputUserPwd");
			String inputUserConfirmPwd = request.getParameter("inputUserConfirmPwd");
			String inputUserName = request.getParameter("inputUserName");

			UserDTO userDTO = new UserDTO(inputUserEmail, inputUserPwd, inputUserName);

			if (inputUserPwd.equals(inputUserConfirmPwd)) // 비밀번호가 일치
				userService.userSignUp(userDTO);
			else // 비밀번호 일치하지 않음
				throw new NotMatchingException("확인 비밀번호와 맞지 않습니다.");

		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 비밀번호와 맞지 않습니다.'); location.href='/userSignUp';</script>");

			out.flush();
		}
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

	// 비밀번호 찾기
	@RequestMapping(value = "/userForgotPwd", method = RequestMethod.GET)
	public String userForgotPwd() {
		return "userForgotPwd";
	}

	// 회원 내 페이지
	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String userDetail() {
		return "userDetail";
	}
}
