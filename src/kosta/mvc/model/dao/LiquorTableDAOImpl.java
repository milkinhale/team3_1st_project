package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.LiquorTable;
import util.DBUtil;

public class LiquorTableDAOImpl implements LiquorTableDAO {

	private Properties profile = DBUtil.getProFile();
	
	@Override
	public List<LiquorTable> selectLiquorTable() throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<LiquorTable> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("liqourTable.selectLiquorTable"));
	       rs = ps.executeQuery(); 
	       while(rs.next()) {
	        	LiquorTable liquorTable = new LiquorTable(rs.getInt(1), rs.getString(2));
	        	list.add(liquorTable);
	        }
	       
		 }finally {
			 DBUtil.dbClose(con, ps, rs);
		 }
		return list;
	}

}
