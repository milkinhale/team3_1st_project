package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import kosta.mvc.model.dto.Customer;
import util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private Properties proFile = DBUtil.getProFile();

	@Override
	public int insertcustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("customer.insertCustomer");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customer.getCustomerId());
			ps.setString(1, customer.getPwd());
			ps.setString(1, customer.getCustomerName());
			ps.setString(1, customer.getBirth());
			ps.setString(1, customer.getEmail());
			ps.setString(1, customer.getAddr());
			ps.setString(1, customer.getContact());
			
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
	/////////////////////TEST¿ë////////////////////////
	public static void main(String[] args) {
		CustomerDAOImpl tmp = new CustomerDAOImpl();
		Customer c = null;
		
		
		try {
			c= tmp.customerLogin("CHOI1", "1111");
			
			System.out.println(c.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/////////////////////TEST¿ë////////////////////////
	

	@Override
	public Customer customerLogin(String customerId, String customerpwd) throws SQLException {
		// TODO Auto-generated method stub
		
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Customer customer=null;
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement("select * from Customer where CUSTOMER_ID=? and pwd=?");
		   ps.setString(1, customerId);
		   ps.setString(2, customerpwd);
		   
	        rs = ps.executeQuery(); 
	        
	        if(rs.next()) {
	        	customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	        }
      }finally {
      	DBUtil.dbClose(con, ps, rs);
      }
		return customer;
	}

	@Override
	public String findcustomerId(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findcusomerPwd(String customerId, String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatecustomerEmail(String customerId, String email) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatecustomerPwd(String customerId, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatecustomerAddr(String customerId, String addr) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletecustomer(String customerId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
