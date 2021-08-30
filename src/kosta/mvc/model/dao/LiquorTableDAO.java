package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.LiquorTable;


public interface LiquorTableDAO {
	
	List<LiquorTable> selectLiquorTable() throws SQLException;
	
}
