package com.graduate.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

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

			UserDTO userDTO = null;

			if (inputUserPwd.equals(inputUserConfirmPwd)) { // 비밀번호가 일치
				userDTO = userService.userSignUp(inputUserEmail, inputUserPwd, inputUserName); // 회원가입
			} else // 비밀번호 일치하지 않음
				throw new NotMatchingException("확인 비밀번호와 맞지 않습니다.");

			if (userDTO == null)
				throw new AlreadyExistingException("이미 존재하는 계정입니다.");
			else {
				System.out.println(userDTO.toString());

				response.sendRedirect("/user/userSignIn");
			}
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 비밀번호와 맞지 않습니다.'); location.href='/user/userSignUp';</script>");

			out.flush();
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 계정입니다.'); location.href='/user/userSignUp';</script>");

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

	// 로그인
	@PostMapping(value = "/userSignIn")
	public void userSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession(true);

			String inputUserEmail = request.getParameter("inputUserEmail");
			String inputUserPwd = request.getParameter("inputUserPwd");

			UserDTO userDTO = userService.userSignIn(inputUserEmail, inputUserPwd);

			if (userDTO == null) // 로그인 실패
				throw new SignInFailException("로그인에 실패하였습니다.");
			else if (userDTO.getUserEmail().equals("admin@admin")) { // 관리자
				session.setAttribute("userSessionName", userDTO.getUserName());

				response.sendRedirect("/");
			} else { // 회원
				session.setAttribute("userSessionName", userDTO.getUserName());
				session.setAttribute("userSessionDTO", userDTO);

				response.sendRedirect("/");
			}
		} catch (SignInFailException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('로그인에 실패하였습니다.'); location.href='/user/userSignIn';</script>");

			out.flush();
		}
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/userForgotPwd", method = RequestMethod.GET)
	public String userForgotPwd() {
		return "userForgotPwd";
	}

	// 비밀번호 찾기
	@PostMapping(value = "/userForgotPwd")
	public void userForgotPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputUserEmail = request.getParameter("inputUserEmail");

			UserDTO userDTO = userService.findOneUser(inputUserEmail);

			if (userDTO == null) // 회원이 존재하지 않는다.
				throw new NotExistingException("존재하지 않는 계정입니다.");
			else { // 임시 비밀번호를 생성해 DB를 업데이트하고 메일을 보내준다.
				userDTO = userService.changeUserPwd(userDTO);
				
				userService.sendPasswordEmail(userDTO, "userForgotPwd");
				
				response.sendRedirect("/user/userSignIn");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 계정입니다.'); location.href='/user/userSignUp';</script>");

			out.flush();
		}
	}

	// 회원 내 페이지
	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String userDetail(Model model, HttpSession session) {
		UserDTO userDTO = (UserDTO)session.getAttribute("userSessionDTO");
		
		// List<PhraseDTO> phraseList = phraseDAO.showAll();
		
		return "userDetail";
	}

	// 로그아웃
	@GetMapping("/userSignOut")
	public String userSignOut(final HttpSession session) {
		if (session.getAttribute("userSessionName") != null)
			session.removeAttribute("userSessionName");

		session.invalidate();

		return "redirect:/";
	}

	// 비밀번호 수정
	@RequestMapping(value = "/userChangePwd", method = RequestMethod.GET)
	public String userChangePwd() {
		return "userChangePwd";
	}

	// 닉네임 수정
	@RequestMapping(value = "/userChangeName", method = RequestMethod.GET)
	public String userChangeName() {
		return "userChangeName";
	}
}
