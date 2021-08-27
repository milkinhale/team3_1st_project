package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;

public interface CustomerDAO {

/**
 * ȸ�������ϱ�	
 **/
	int insertcustomer(Customer customer) throws SQLException;
/**
 * �α����ϱ�
 **/
   Customer customerLogin(String customerId, String customerpwd)throws SQLException;

/**
 * 	ȸ������ã��(���̵�)
 **/
	String findcustomerId (String email) throws SQLException;

/**
 * 	 ȸ������ã��(���) 
 **/
	String findcusomerPwd (String customerId, String email) throws SQLException;
	
/**
 * 	ȸ����������(�̸���)
 **/
	int updatecustomerEmail (String customerId, String email) throws SQLException;
	
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
