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

/////////////////////TEST////////////////////////
/*
public static void main(String[] args) {
CustomerDAOImpl cd = new CustomerDAOImpl();

	Customer c = null;

try {
	c = new Customer( "hong", "111","홍여원","96-08-06","123@네이버","부산 금정구 남산동","123456");
	System.out.println(cd.insertCustomer(c));

	} catch (Exception e) {
		e.printStackTrace();
		}
	}
*/
/*
 public static void main(String[] args) {
	CustomerDAOImpl cd = new CustomerDAOImpl();
	
	Customer c = null;
	
	try {
		c =  cd.findCustomerId("hong","111");
		System.out.println(c);
	}catch(Exception e) {
		e.printStackTrace();
	}
}	
 
 
public static void main(String[] args) {
		CustomerDAOImpl cd = new CustomerDAOImpl();

			String c = null;
			
			try {
				c =  cd.findCustomerId("AAA111@naver.com");
				System.out.println(c);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	//////////////////////////////////////////////////
/*	public static void main(String[] args) {
		CustomerDAOImpl cd = new CustomerDAOImpl();

			String c = null;
			
			try {
				c = cd.findCustomerPwd("CHOI1", "AAA111@naver.com");
				System.out.println(c);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
*/
	
/////////////////////////////////////////////


	@Override
	public int insertCustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("customer.insertCustomer");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customer.getCustomerId());
			ps.setString(2, customer.getPwd());
			ps.setString(3, customer.getCustomerName());
			ps.setString(4, customer.getBirth());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getAddr());
			ps.setString(7, customer.getContact());
			
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	
/////////////////////////////////////////////////
	//로그인하기
	
	@Override
	public Customer customerLogin(String customerId, String customerpwd) throws SQLException {
		
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Customer customer=null;
		 try {
		   con = DBUtil.getConnection();
		   ps = con.prepareStatement(proFile.getProperty("customer.customerLogin"));
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


	//email로  id찾기
	
	@Override
	public String findCustomerId(String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Id = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerId")) ;
			
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Id = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		return Id;
	}
		
	
// pwd 찾기  -아이디입력 + 이메일 
	@Override
	public String findCustomerPwd(String customerId, String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerPwd")) ;
			
			ps.setString(1, email);
			ps.setString(2, customerId);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				pwd = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		
		return pwd;
	}
	
	
/////////////////////////////////////////////////////////////////
	//회원정보수정 (이메일 수정)
	
	@Override
	public int updateCustomerEmail(String customerId, String email) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerEmail");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set email = ? where customer_id = ?
			ps.setString(1, email);
			ps.setString(2, customerId);

			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
//////////////////////////////////////////////////////////
// 회원정보수정 (비밀번호)
	
	@Override
	public int updateCustomerPwd(String customerId, String pwd) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerPwd");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set pwd = ? where customer_id = ? 
			ps.setString(1, pwd);
			ps.setString(2, customerId);

			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

///////////////////////////////////////////////////
//	 회원정보수정 (주소변경)	

	@Override
	public int updateCustomerAddr(String customerId, String addr) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerAddr");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set addr = ? where customer_id= ?
			ps.setString(1, addr);
			ps.setString(2, customerId);
			
			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
//////////////////////////////////////////////
// 회원탈퇴	
	
	@Override
	public int deleteCustomer(String customerId) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.deleteCustomerPwd");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			ps.setString(1, customerId);
			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}	

}
