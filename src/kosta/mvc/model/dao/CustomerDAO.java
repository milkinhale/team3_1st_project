package kosta.mvc.model.dao;

import java.sql.SQLException;

public interface CustomerDAO {

/**
 * 회원가입하기	
 **/
	int insertcustomer(Customer customer) throws SQLException;
/**
 * 로그인하기
 **/
   customerLogin(String customerId, String customerwd)throws SQLException;

/**
 * 	회원정보찾기(아이디)
 **/
	String findcustomerId (String email) throws SQLException;

/**
 * 	 회원정보찾기(비번) 
 **/
	String findcusomerPwd (String customerId, String eamil) throws SQLException;
	
/**
 * 	회원정보수정(이메일)
 **/
	int updatecustomerEmail (String customerId) throws SQLException;
	
/**
 *  회원정보수정(비번)
 **/
	int updatecustomerPwd (String customerId, String pwd) throws SQLException;
	
/**
 *  회원정보수정(주소) 	
 **/
	int updatecustomerAddr (String customerId, String addr) throws SQLException;

/**
 * 회원 탈퇴  
 **/
	int deletecustomer (String customerId) throws SQLException;
}
