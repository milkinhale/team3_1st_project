package kosta.mvc.model.dao;

import java.sql.SQLException;

public interface CustomerDAO {

/**
 * ȸ�������ϱ�	
 **/
	int insertcustomer(Customer customer) throws SQLException;
/**
 * �α����ϱ�
 **/
   customerLogin(String customerId, String customerwd)throws SQLException;

/**
 * 	ȸ������ã��(���̵�)
 **/
	String findcustomerId (String email) throws SQLException;

/**
 * 	 ȸ������ã��(���) 
 **/
	String findcusomerPwd (String customerId, String eamil) throws SQLException;
	
/**
 * 	ȸ����������(�̸���)
 **/
	int updatecustomerEmail (String customerId) throws SQLException;
	
/**
 *  ȸ����������(���)
 **/
	int updatecustomerPwd (String customerId, String pwd) throws SQLException;
	
/**
 *  ȸ����������(�ּ�) 	
 **/
	int updatecustomerAddr (String customerId, String addr) throws SQLException;

/**
 * ȸ�� Ż��  
 **/
	int deletecustomer (String customerId) throws SQLException;
}
