package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;

public interface CustomerDAO {

/**
 * ȸ�������ϱ�	
 **/
	int insertCustomer(Customer customer) throws SQLException;
	
/**
 * ȸ�� ���̵� �ߺ� üũ	
 **/
	String customerIdDuplicationCheck(String customerId) throws SQLException;
	
	
/**
 * �α����ϱ�
 **/
   Customer customerLogin(String customerId, String customerpwd)throws SQLException;

/**
 * 	ȸ������ã��(���̵�)
 **/
	String findCustomerId (String email) throws SQLException;

/**
 * 	 ȸ������ã��(���) 
 **/
	String findCustomerPwd (String customerId, String email) throws SQLException;

/**
 * 	ȸ������ã��(�̸�) -> ���̵� ������ �̸��� ���´�. 
 * */
	String findCustomerName (String customerId) throws SQLException;

/**
 * 	ȸ����������(�̸���)
 **/
	int updateCustomerEmail (String customerId, String email) throws SQLException;
	
/**
 *  ȸ����������(���)
 **/
	int updateCustomerPwd (String customerId, String pwd) throws SQLException;
	
/**
 *  ȸ����������(�ּ�) 	
 **/
	int updateCustomerAddr (String customerId, String addr) throws SQLException;

/**
 * ȸ�� Ż��  
 **/
	int deleteCustomer (String customerId) throws SQLException;
}
