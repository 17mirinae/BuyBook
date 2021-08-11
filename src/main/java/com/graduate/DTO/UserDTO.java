package com.graduate.DTO;

public class UserDTO {
	private String userId;
	private String userPwd;
	private String userEmail;

	public UserDTO(String userId, String userPwd, String userEmail) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserDTO [userPwd=" + userPwd + ", userEmail=" + userEmail + "]";
	}
}
