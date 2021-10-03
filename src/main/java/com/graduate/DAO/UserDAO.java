package com.graduate.DAO;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Component;
import java.util.*;
import javax.sql.*;

import com.graduate.DTO.*;

@Component
public class UserDAO {
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

	public void insertUser(UserDTO userDTO) {
		// 회원가입
		jdbcTemplate.update("INSERT INTO USER(USEREMAIL, USERPWD, USERNAME) VALUES('" + userDTO.getUserEmail() + "', '"
				+ userDTO.getUserPwd() + "', '" + userDTO.getUserName() + "');");
	}

	public void deleteUser(String inputUserEmail) {
		// 회원 삭제
		jdbcTemplate.update("DELETE FROM USER WHERE USEREMAIL='" + inputUserEmail + "';");
	}

	public void updatePwd(UserDTO userDTO, String inputUserPwd) {
		// 회원 비밀번호 수정
		System.out.println(inputUserPwd);
		System.out.println(userDTO.toString());
		jdbcTemplate.update(
				"UPDATE USER SET USERPWD='" + inputUserPwd + "' WHERE USEREMAIL='" + userDTO.getUserEmail() + "';");
		System.out.println(userDTO.toString());
	}

	public void updateName(UserDTO userDTO, String inputUserName) {
		// 회원 닉네임 변경
		jdbcTemplate.update(
				"UPDATE USER SET USERNAME='" + inputUserName + "' WHERE USEREMAIL='" + userDTO.getUserEmail() + "';");
	}
}
