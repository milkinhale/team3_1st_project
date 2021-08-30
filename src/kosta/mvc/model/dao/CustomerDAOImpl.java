package kosta.mvc.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Customer;

import util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private Properties proFile = DBUtil.getProFile();

/////////////////////TEST////////////////////////
public static void main(String[] args) {
	CustomerDAOImpl cd = new CustomerDAOImpl();
	Customer c = null;

	try {
	/*	
		c = new Customer("m", "tiger","마스크","00-03-04","masklover@naver.com","경기도 판교","010-3333-3333"); 
		System.out.println(cd.insertCustomer(c));
	
		//customerLogin(String customerId, String customerpwd)
		c = cd.customerLogin("hong", "111");
		System.out.println(c);
		
		//updateCustomerEmail(String customerId, String email)
		System.out.println(cd.updateCustomerEmail("JANG", "JANG@naver.com"));
		
		//updateCustomerPwd(String customerId, String pwd)
		System.out.println(cd.updateCustomerPwd("YOO", "1234"));
	
		//updateCustomerAddr(String customerId, String addr)
		System.out.println(cd.updateCustomerAddr("JANG", "서울시 서초구"));
		
		//deleteCustomer(String customerId)
		System.out.pritnln(cd.deleteCustomer());
		
		System.out.println(cd.findCustomerId("AAA111@naver.com"));
		
		System.out.println(cd.findCustomerPwd("CHOI1", "AAA111@naver.com"));
		
		System.out.println(cd.findCustomerName("CHOI1"));
		

	//	List<Customer> list = dao.selectCustomerListAll();
		for(Customer ct : list) 
		System.out.println(ct);
*/		
		System.out.print(cd.deleteCustomer("hong"));
	
		}catch (Exception e) {
		e.printStackTrace();
	}
}
/////////////////////TEST////////////////////////


	@Override
	public int insertCustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("customer.insertCustomer");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//insert into customer(customer_id, pwd, customer_name, birth, email, addr, contact, sign_date ) 
			//values( ?, ?, ?, ?, ?, ?, ?, sysdate)
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
////////////////////////////////////////////////
	// 아이디 중복 체크 
	@Override
	public String customerIdDuplicationCheck(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Id = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.customerIdDuplicationCheck")) ;
			
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Id = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		return Id;
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
			
			//SELECT PWD FROM CUSTOMER WHERE EMAIL = ? AND CUSTOMER_ID = ?
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
	
	@Override
	public String findCustomerName(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerName")) ;
			
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		
		return name;
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
		String sql = proFile.getProperty("customer.deleteCustomer");
		
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
	
	/**
	 * 회원인지 판매자 확인  
	 * @return seller일 경우 "SELLER"(대문자 유의!) 값 리턴. 아닐 경우 null값 리턴  
	 **/
	public String sellerCheck (String customerId) throws SQLException{
		String seller = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("customer.sellerCheck");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				seller = rs.getString(1);
			}			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return seller;
	}

	
	/**
	 *  관리자 - 전체 회원 리스트 보기 
	 **/

	@Override
	public List<Customer> selectCustomerListAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		List<Customer>customerList = new ArrayList<Customer>();
		String sql = proFile.getProperty("customer.selectCustomerListAll" );
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
	
		}catch(Exception e ) {
			while(rs.next()) {
				Customer customerDto= new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				customerList.add(customerDto);
			}
		}finally {
			DBUtil.dbClose(con, ps,rs);
		}
		return customerList;
	}

	
	/**
	 * 관리자 - 회원강퇴 
	 **/
}
