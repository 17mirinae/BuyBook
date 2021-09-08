package com.graduate.Service;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.DAO.UserDAO;
import com.graduate.DTO.UserDTO;

@Service
public class UserService {
	private UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO _userDAO) {
		this.userDAO = _userDAO;
	}
	
	public UserDTO userSignUp(UserDTO _userDTO) {
		// 회원가입
		UserDTO userDTO = userDAO.selectByUserID(_userDTO.getUserEmail());
		
		if(userDTO == null) { // 회원이 존재하지 않음 --> 회원가입 진행
			userDAO.insertUser(_userDTO);
			
			return _userDTO; // 가입한 계정 반환
		} else { // 회원이 이미 존재함
			System.out.println("이미 존재하는 계정입니다.");
			
			return null;
		}
	}
	
	public UserDTO userSignIn(String _userId, String _userPwd) {
		// 로그인
		UserDTO userDTO = userDAO.selectByUserID(_userId); // 입력된 정보로 회원 찾기
		
		if(userDTO == null) { // 회원이 존재하지 않음
			System.out.println("회원이 존재하지 않습니다.");
			
			return null;
		} else if (userDTO.getUserPwd().equals(_userPwd)) {
			
		}
		return userDTO;
	}
	
	public void sendPasswordEmail(UserDTO userDTO, String div) throws Exception {
		// 비밀번호를 잊었을 시에 초기화 해주는 기능
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; // 지메일 이용시 smtp.gmail.com
		String hostSMTPid = ""; // "서버 이메일 주소(보내는 사람 이메일 주소)";
		String hostSMTPpwd = ""; // "서버 이메일 비번(보내는 사람 이메일 비번)";
		
		// 보내는 사람 Email, 제목, 내용
		String fromEmail = "admin@admin"; // "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
		String fromName = "MinGW"; // "프로젝트이름 또는 보내는 사람 이름";
		String subject = "";
		String msg = "";
		
		if(div.equals("forgotPwd")) {
			subject = "MinGW's Diary 임시 비밀번호입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += userDTO.getUserId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += userDTO.getUserPwd() + "</p></div>";
		}
		
		// 받는 사람 E-Mail 주소
		String mail = userDTO.getUserEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); // 지메일 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}
}
