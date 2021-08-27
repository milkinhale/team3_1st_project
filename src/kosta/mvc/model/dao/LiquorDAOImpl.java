package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.Orders;
import util.DBUtil;

public class LiquorDAOImpl implements LiquorDAO {
	
	private Properties profile = DBUtil.getProFile();
	
	public static void main(String[] args) {
		LiquorDAOImpl dao = new LiquorDAOImpl();
		
		
		try {
			List<Liquor> list = dao.liquorsSelectByLiquorPrice(16000);
			for(Liquor l : list) {
				System.out.println(l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Liquor> liquorsSelectByLiquorPrice(int price) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Liquor> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("liquor.liquorsSelectByLiquorPrice"));
		   ps.setInt(1, price);
		   ps.setInt(2, price);
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
	public List<Liquor> liquorsSelectByLiquorType(String liquorType) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Liquor> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("liqour.liquorsSelectByLiquorType"));
		   ps.setString(1, liquorType);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Liquor liquors = new Liquor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
	        	list.add(liquors);
	        }
		 }finally {
			 DBUtil.dbClose(con, ps, rs);
		 }
		return list;
	}

	@Override
	public Liquor liquorSelectByLiquorNo(int liquorNo) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Liquor liquor;
		  
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("liquor.liquorSelectByLiquorNo"));
		   ps.setInt(1, liquorNo);
	       rs = ps.executeQuery(); 
	       liquor = new Liquor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
	        
		 }finally {
			 DBUtil.dbClose(con, ps, rs);
		 }
		return liquor;
	}
	
	@Override
	public int insertLiquor(Liquor liquorDTO) throws SQLException{
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = profile.getProperty("liquor.insertLiquor");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//LIQUOR_TABLE_NO
			ps.setInt(1, liquorDTO.getLiquorTableNo());
			//LIQUOR_NAME
			ps.setString(2, liquorDTO.getLiquorName());
			//LIQUOR_PRICE
			ps.setInt(3, liquorDTO.getLiquorPrice());
			//ADD_DATE
			ps.setString(4, liquorDTO.getAddDate());
			
			result = ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public int updateLiquor(Liquor liquorDTO) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = profile.getProperty("liquor.updateLiquor");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			//liquor_name = ?, liquor_price = ? where liquor_no = ? 
			ps.setString(1, liquorDTO.getLiquorName());
			ps.setInt(2, liquorDTO.getLiquorPrice());
			ps.setInt(3, liquorDTO.getLiquorNo());
			
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
	@Override
	public int updateStock(int count, int liquorNo) throws SQLException{
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		//Liquor liquorDTO = new Liquor();
		String sql = profile.getProperty("liquor.updateStock");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			//update liquor set stock=stock-? where liquor_no=?
			ps.setInt(1, count);
			ps.setInt(2, liquorNo);
			
			result = ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
		
	
	
	@Override
	public int deleteLiquor(int liquorNo) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = profile.getProperty("liquor.deleteLiquor");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//delete from liquor where liquor_no = ?
			ps.setInt(1, liquorNo);
			
			result = ps.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
