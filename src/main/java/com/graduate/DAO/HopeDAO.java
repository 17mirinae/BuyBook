package com.graduate.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graduate.DTO.*;

@Component
public class HopeDAO {
	private JdbcTemplate jdbcTemplate;

	public HopeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<HopeDTO> showAll() {
		List<HopeDTO> result = jdbcTemplate.query("SELECT * FROM HOPE;", (rs, rowNum) -> {
			HopeDTO hopeDTO = new HopeDTO(rs.getString("HOPEISBN"), rs.getString("HOPETITLE"), rs.getInt("HOPENUMBER"),
					rs.getString("HOPELINK"));
			return hopeDTO;
		});

		return result;
	}

	public HopeDTO selectByHopeISBN(String inputHopeISBN) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM HOPE WHERE HOPEISBN = '" + inputHopeISBN + "';",
					(rs, rowNum) -> new HopeDTO(rs.getString("HOPEISBN"), rs.getString("HOPETITLE"),
							rs.getInt("HOPENUMBER"), rs.getString("HOPELINK")));
		} catch (Exception ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public void insertHope(HopeDTO hopeDTO) {
		jdbcTemplate.update("INSERT INTO HOPE(HOPEISBN, HOPETITLE, HOPENUMBER, HOPELINK) VALUES('"
				+ hopeDTO.getHopeISBN() + "', '" + hopeDTO.getHopeTitle() + "', " + hopeDTO.getHopeNumber() + ", '"
				+ hopeDTO.getHopeLink() + "');");
	}

	public void updateHope(String inputHopeISBN) {
		jdbcTemplate.update("UPDATE HOPE SET HOPENUMBER = HOPENUMBER + 1 WHERE HOPEISBN = '" + inputHopeISBN + "';");
	}
}
