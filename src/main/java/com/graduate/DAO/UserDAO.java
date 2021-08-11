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

	public UserDTO selectByUserID(String inputUserID) {
		// 한 명의 회원 조회
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USERID='" + inputUserID + "';", (rs,
					rowNum) -> new UserDTO(rs.getString("USERID"), rs.getString("USERPWD"), rs.getString("USEREMAIL")));
		} catch (Exception ex) {
			return null;
		}
	}
	
}
