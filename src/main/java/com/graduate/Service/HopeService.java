package com.graduate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.graduate.DAO.*;
import com.graduate.DTO.*;

@Service
public class HopeService {
	private HopeDAO hopeDAO;

	@Autowired
	public HopeService(HopeDAO _hopeDAO) {
		this.hopeDAO = _hopeDAO;
	}

	public List<HopeDTO> showAll() {
		return hopeDAO.showAll();
	}

	public HopeDTO selectByHopeISBN(String inputHopeISBN) {
		return hopeDAO.selectByHopeISBN(inputHopeISBN);
	}

	public void insertHope(HopeDTO hopeDTO) {
		hopeDAO.insertHope(hopeDTO);
	}

	public void updateHope(String inputHopeISBN) {
		hopeDAO.updateHope(inputHopeISBN);
	}
}
