package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.LiquorTable;


public interface LiquorTableDAO {
	
	/**
	 * 양주 카테고리
	 * */
	List<LiquorTable> selectLiquorTable() throws SQLException;
	
}
