package com.graduate.DAO;

import java.util.*;

import javax.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.graduate.DTO.*;

@Component
public class NoticeDAO {
	private JdbcTemplate jdbcTemplate;

	public NoticeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public NoticeDTO selectByNoticeNo(int inputNoticeNo) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM NOTICE WHERE NOTICENO = " + inputNoticeNo + ";",
					(rs, rowNum) -> new NoticeDTO(rs.getInt("NOTICENO"), rs.getString("NOTICETITLE"),
							rs.getDate("NOTICEDATE"), rs.getString("NOTICECONTENT")));
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public List<NoticeDTO> showAll() {
		List<NoticeDTO> result = jdbcTemplate.query("SELECT * FROM NOTICE;", (rs, rowNum) -> {
			NoticeDTO noticeDTO = new NoticeDTO(rs.getInt("NOTICENO"), rs.getString("NOTICETITLE"),
					rs.getDate("NOTICEDATE"), rs.getString("NOTICECONTENT"));
			return noticeDTO;
		});
		return result;
	}

	public List<NoticeDTO> showFive() {
		List<NoticeDTO> result = jdbcTemplate.query("SELECT * FROM NOTICE ORDER BY NOTICENO DESC LIMIT 5;",
				(rs, rowNum) -> {
					NoticeDTO noticeDTO = new NoticeDTO(rs.getInt("NOTICENO"), rs.getString("NOTICETITLE"),
							rs.getDate("NOTICEDATE"), rs.getString("NOTICECONTENT"));
					return noticeDTO;
				});
		return result;
	}

	public void insertNotice(NoticeDTO noticeDTO) {
		jdbcTemplate.update("INSERT INTO NOTICE(TITLE, DATE, CONTENT) VALUES('" + noticeDTO.getNoticeTitle()
				+ "', NOW(), '" + noticeDTO.getNoticeContent() + "');");
	}

	public void deleteNotice(int inputNoticeNo) {
		jdbcTemplate.update("DELETE FROM NOTICE WHERE NOTICENO = " + inputNoticeNo + ";");
	}

}
