package com.graduate.DTO;

public class UserDTO {
	private String userEmail; // 회원 이메일
	private String userPwd; // 회원 비밀번호
	private String userName; // 회원 이름

	public UserDTO(String userEmail, String userPwd, String userName) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDTO [userEmail=" + userEmail + ", userPwd=" + userPwd + ", userName=" + userName + "]";
	}

}
