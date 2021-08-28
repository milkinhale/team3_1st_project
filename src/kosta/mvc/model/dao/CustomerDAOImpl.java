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

/////////////////////TEST용////////////////////////
public static void main(String[] args) {
CustomerDAOImpl tmp = new CustomerDAOImpl();
try {
/*
CustomerDAOImpl da = new customerDAOImpl;
Connection c = null;

for(customer 
for(Liquor l : list) {
System.out.println(l);
}
System.out.println("-------------------------------");
List<Liquor> list2 = dao.liquorsSelectByLiquorType(1);
for(Liquor l : list2) {
System.out.println(l);
}
System.out.println("-------------------------------");
Liquor liquor1 = dao.liquorSelectByLiquorNo(1);
System.out.println(liquor1);
System.out.println("-------------------------------");
//insert into liquor values(liquor_no, ?, ?, ?, default, ?)
//Liquor liquor2 = dao.insertLiquor(Liquor liquorDTO)
Liquor liquor2 = new Liquor(1, "새 양주이름", 13000, "21-08-23");
System.out.println(dao.insertLiquor(liquor2));
System.out.println("-------------------------------");
Liquor liquor3 = new Liquor(1, "바꾼 양주이름", 200000);
System.out.println(dao.updateLiquor(liquor3));

System.out.println("-------------------------------");
System.out.println(dao.deleteLiquor(1));
*/


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
/////////////////////TEST용////////////////////////
/*	public static void main(String[] args) {
		CustomerDAOImpl tmp = new CustomerDAOImpl();
		Customer c = null;
		
		
		try {
			c= tmp.customerLogin("CHOI1", "1111");
			
			System.out.println(c.toString());
		} catch (Exception e) {
 
		}
	}
*/
	
////////////////////////////////////////////
	//로그인하기
	
	@Override
	public Customer customerLogin(String customerId, String customerpwd) throws SQLException {
		
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Customer customer=null;
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(proFile.getProperty("customer.customerLogin"));
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
	
/////////////////////////////////////////////////////////////////////
	//email로  id찾기
	
	@Override
	public String findcustomerId(String email) throws SQLException {
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

///////////////test /////////////////////
/*	public static void main(String[] args) {
		CustomerDAOImpl tmp = new CustomerDAOImpl();
		Customer c = null;
		
		
		try {
			c= tmp.customerLogin("CHOI1", "AAA111@naver.com");
			
			System.out.println(c.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/
/////////////////////////////////////////////		
	
// pwd 찾기  -아이디입력 + 이메일 
	@Override
	public String findcusomerPwd(String customerId, String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerPwd")) ;
			ps.setString(1, pwd);
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
	public int updatecustomerEmail(String customerId, String email) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerEmail");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			ps.setString(1, email);
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
	public int updatecustomerPwd(String customerId, String pwd) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerPwd");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			ps.setString(1, pwd);
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
	public int updatecustomerAddr(String customerId, String addr) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerAddr");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			ps.setString(1, addr);
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
	public int deletecustomer(String customerId) throws SQLException {
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
