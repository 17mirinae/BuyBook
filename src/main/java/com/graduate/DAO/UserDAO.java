package com.graduate.DAO;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Component;
import java.util.*;
import javax.sql.*;

import com.graduate.DTO.*;

@Component
public class UserDAO {
	private UserDTO userDTO;
	private JdbcTemplate jdbcTemplate;

	public UserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserDTO selectByUserEmail(String inputUserEmail) {
		// 한 명의 회원 조회
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USEREMAIL='" + inputUserEmail + "';",
					(rs, rowNum) -> new UserDTO(rs.getString("USEREMAIL"), rs.getString("USERPWD"),
							rs.getString("USERNAME")));
		} catch (Exception ex) {
			return null;
		}
	}

	public void insertUser(UserDTO _userDTO) {
		// 회원가입
		this.userDTO = _userDTO;

		jdbcTemplate.update("INSERT INTO USER(USEREMAIL, USERPWD, USERNAME) VALUES('" + userDTO.getUserEmail() + "', '"
				+ userDTO.getUserPwd() + "', '" + userDTO.getUserName() + "');");
	}

	public void deleteUser(String inputUserEmail) {
		// 회원 삭제
		jdbcTemplate.update("DELETE FROM USER WHERE USEREMAIL='" + inputUserEmail + "';");
	}

	public void updatePwd(UserDTO _userDTO, String inputUserPwd) {
		// 회원 비밀번호 수정
		this.userDTO = _userDTO;

		jdbcTemplate.update(
				"UPDATE USER SET USERPWD='" + inputUserPwd + "' WHERE USEREMAIL='" + userDTO.getUserEmail() + "';");
	}

	public void updateName(UserDTO _userDTO, String inputUserName) {
		// 회원 닉네임 변경
		this.userDTO = _userDTO;

		jdbcTemplate.update(
				"UPDATE USER SET USERNAME='" + inputUserName + "' WHERE USERID='" + userDTO.getUserEmail() + "';");
	}
}
