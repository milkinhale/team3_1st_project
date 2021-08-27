package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Liquor;
import util.DBUtil;

public class LiquorDAOImpl implements LiquorDAO {
	
	private Properties profile = DBUtil.getProFile();

	@Override
	public List<Liquor> goodsSelectByGoodsPrice(int price) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Liquor> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement("select * from LIQUOR where LIQUOR()");
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Liquor liquors  = new Liquor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
	        	list.add(liquors);
	        }
    }finally {
    	DBUtil.dbClose(con, ps, rs);
    }
		return list;
	}

	
	@Override
	public List<Liquor> goodsSelectByGoodsKind(String liqourType) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Liquor> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement("select * from LIQUOR where LIQUOR()");
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Liquor liquors  = new Liquor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
	        	list.add(liquors);
	        }
  }finally {
  	DBUtil.dbClose(con, ps, rs);
  }
		return list;
	}

	@Override
	public Liquor goodsSelectByGoodsName(String liqourName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGoods(Liquor liquorDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGoods(Liquor liquorDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGoods(int liquorNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
