package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.OrderDetail;
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
	int updateOrder(int orderNo, String orderStatusMessage)throws SQLException;
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	int deleteOrder(int orderNo)throws SQLException;
	
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
	int[] orderDetailInsert(Connection con  , Orders order, int seq) throws SQLException;
	
	 /**
	  * �ֹ� ��ȣ�� �ֹ� ���� ��������.
	  * */
	 Orders selectOrderByOrderNo(int orderNo) throws SQLException;
	 
	 /**
		 * ���� �ѹ��� �� ���̵� ��������
		 * 
		 * */
	String getCustomerIdByOrderNo(int orderNo) throws SQLException;
	
	/**
	 * �ֹ���ȣ�� �ֹ����� ���� ��������
	 * */
	String getOrderStatusByOrderNo(int orderNo) throws SQLException;

	 /**
	  * �ش� ȸ�� ��ȣ�� �Է��ϰ� ��ٱ��ϸ� ������ü�� �����
	  * */
	List<OrderDetail> convertCartIntoOrderDetailListByCustomerId(String customer_id) throws SQLException, NotFoundException;
	
	/**
	 * ���� �ѹ��� ������ ���ؿ���.
	 * */
	int getSalePercentByCouponNo(int couponNo) throws SQLException;
	 
}
