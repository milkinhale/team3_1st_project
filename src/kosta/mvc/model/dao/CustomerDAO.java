package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;

public interface CustomerDAO {

/**
 * 회원가입하기	
 **/
	int insertCustomer(Customer customer) throws SQLException;
	
/**
 * 회원 아이디 중복 체크	
 **/
	String customerIdDuplicationCheck(String customerId) throws SQLException;
	
	
/**
 * 로그인하기
 **/
   Customer customerLogin(String customerId, String customerpwd)throws SQLException;

/**
 * 	회원정보찾기(아이디)
 **/
	String findCustomerId (String email) throws SQLException;

/**
 * 	 회원정보찾기(비번) 
 **/
	String findCustomerPwd (String customerId, String email) throws SQLException;

/**
 * 	회원정보찾기(이름) -> 아이디를 넣으면 이름이 나온다. 
 * */
	String findCustomerName (String customerId) throws SQLException;

/**
 * 	회원정보수정(이메일)
 **/
	int updateCustomerEmail (String customerId, String email) throws SQLException;
	
/**
 *  회원정보수정(비번)
 **/
	int updateCustomerPwd (String customerId, String pwd) throws SQLException;
	
/**
 *  회원정보수정(주소) 	
 **/
	int updateCustomerAddr (String customerId, String addr) throws SQLException;

/**
 * 회원 탈퇴  
 **/
	int deleteCustomer (String customerId) throws SQLException;
}
