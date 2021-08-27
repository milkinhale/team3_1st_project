package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Orders;

public interface OrderDAO {
	
	/**
	 * �ֹ� ���� ��ü ����
	 * 		�Ǹ��ڿ�޴����� �����.
	 * */
	List<Orders> orderSelectAll()throws SQLException;
	
	/**
	 * ȸ���� �ֹ���������
	 * 		������ �ֹ����� ����� �Ǹ��� �ֹ� �˻����� �����
	 * */
	List<Orders> orderSelectByCustomerId(String customerId)throws SQLException;
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��ڰ� �ֹ����� �����Ҷ� �����.
	 * */
	int updateOrder(Orders order, String orderStatusMessage)throws SQLException;
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	int deleteOrder(Orders order)throws SQLException;
	
	 /**
	   * �ֹ��ϱ�
	   *  1) orders���̺� insert
	   *  2) order_line���̺� insert
	   *  3) ���(stock)���� ��Ű��(update)
	   * 	
	   * 	������ �޴����� �����.
	   * 	���ǿ� ���� üũ�ϴ°� ���� ����! 
	   * 
	   * */
	int insertOrder(Orders order)throws SQLException;
	
	/**
	 * �ֹ��� ����ϱ� 
	 * */
	int[] orderDetailInsert(Connection con  , Orders order) throws SQLException;
	
}
