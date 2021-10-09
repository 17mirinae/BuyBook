package com.graduate.DTO;

public class UserDTO {
	private String userEmail; // 회원 이메일
	private String userPwd; // 회원 비밀번호
	private String userName; // 회원 이름
	private int userPoint; // 회원 포인트

	public UserDTO(String userEmail, String userPwd, String userName) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPoint = 3000;
	}

	public UserDTO(String userEmail, String userPwd, String userName, int userPoint) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPoint = userPoint;
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

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	@Override
	public String toString() {
		return "UserDTO [userEmail=" + userEmail + ", userPwd=" + userPwd + ", userName=" + userName + ", userPoint="
				+ userPoint + "]";
	}

}
