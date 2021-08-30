package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.LiquorTableDAO;
import kosta.mvc.model.dao.LiquorTableDAOImpl;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.LiquorTable;

public class LiquorTableService {
	LiquorTableDAO liquorTableDao = new LiquorTableDAOImpl();
	
	public List<LiquorTable> selectLiquorTable() throws SQLException{
		List<LiquorTable> list = liquorTableDao.selectLiquorTable();
		return list;
	}
}
