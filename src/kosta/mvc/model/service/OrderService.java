 package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.OrderDAO;
import kosta.mvc.model.dao.OrderDAOImpl;
import kosta.mvc.model.dto.Orders;

public class OrderService {
	OrderDAO orderDao = new OrderDAOImpl();
	
	/**
	 * �ֹ� ���� ��ü ����
	 * 		�Ǹ��ڿ�޴����� �����.
	 * */
	public List<Orders> orderSelectAll() throws SQLException{
		List<Orders> list = orderDao.orderSelectAll();
		 if(list==null || list.size()==0)throw new SQLException("�ֹ������� �����ϴ�.");
		 return list;
	}

	 /**
	  * ȸ���� �ֹ� ��������
	  * */
	 public List<Orders> selectOrdersByUserId(String customerId)throws SQLException{
		 List<Orders> list = orderDao.orderSelectByCustomerId(customerId);
		 if(list==null || list.size()==0)throw new SQLException(customerId+"�� �ֹ������� �����ϴ�.");
		 return list;
	 }
	 /**
		 * �ֹ� ����
		 * 		�Ǹ��ڰ� �ֹ����� �����Ҷ� �����.
		 * */
	public void updateOrder(Orders order, String orderStatusMessage)throws SQLException{
		int result =  orderDao.updateOrder(order, orderStatusMessage);
		if(result==0)throw new SQLException("�ֹ� ������ �����Ͽ����ϴ�.");
	}
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	public void deleteOrder(Orders order)throws SQLException{
		int result =  orderDao.deleteOrder(order);
		if(result==0)throw new SQLException("�ֹ� ������ �����Ͽ����ϴ�.");
	}
		
   /**
    * �ֹ��ϱ�
    * */
	 public void insertOrders(Orders orders) throws SQLException{
		int result =  orderDao.insertOrder(orders);
		if(result==0)throw new SQLException("�ֹ��ϱⰡ �����Ͽ����ϴ�.");
	 }
	 
	 /**
	  * �ֹ� ��ȣ�� �ֹ� ���� ��������.
	  * */
	 public Orders selectOrderByOrderNo(int orderNo) throws SQLException{
		 Orders returnVal = orderDao.selectOrderByOrderNo(orderNo);
		 if(returnVal == null) throw new SQLException(orderNo + "���� �ֹ��� �����ϴ�.");
		 return returnVal;
	 }
	 
}
