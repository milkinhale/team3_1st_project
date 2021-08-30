 package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dao.OrderDAO;
import kosta.mvc.model.dao.OrderDAOImpl;
import kosta.mvc.model.dto.OrderDetail;
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
	public void updateOrder(int orderNo, String orderStatusMessage)throws SQLException{
		int result =  orderDao.updateOrder(orderNo, orderStatusMessage);
		if(result==0)throw new SQLException("�ֹ� ������ �����Ͽ����ϴ�.");
	}
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	public void deleteOrder(int orderNo)throws SQLException{
		
		if(checkOrderStatus(orderNo)) {
			int result =  orderDao.deleteOrder(orderNo);
			if(result==0)throw new SQLException("�ֹ� ������ �����Ͽ����ϴ�.");
		}else {
			throw new SQLException("���� �ֹ� ���¿����� �ֹ� ��Ұ� �Ұ����մϴ�.");
		}
	}
		
   /**
    * �ֹ��ϱ�
    * */
	 public void insertOrders(Orders orders, int couponNo) throws SQLException{
		//���� �ѹ��� ��% �����ϴ��� �˾Ƴ���
		 int salePercent = orderDao.getSalePercentByCouponNo(couponNo);
		
		 //���� ��ü�� ��% ���� �޴��� �־��ֱ�
		orders.setDiscount(salePercent);
		
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
	 
	 /**
	  * �ֹ� ��ȣ�� �ֹ� ���� üũ�ϱ�.
	  * @return : true �� ����Ȯ���� ��, �ֹ� ���� ����. 
	  * 		  false�� ����Ȯ������ �ƴ�. ��, �ֹ� ���� �Ұ���.
	  * */
	 public boolean checkOrderStatus(int orderNo) throws SQLException{
		 boolean returnValue = false;
		 
		 String orderStatus = orderDao.getOrderStatusByOrderNo(orderNo);
		 
		 if(orderStatus.equals("����Ȯ����")) returnValue = true;
		 
		 return returnValue;
	 }
	 /**
	  * ȸ�� ���̵�� ��ٱ��ϸ� �ֹ��� ����Ʈ�� ��ȯ�ϱ�
	  * */
	 public List<OrderDetail> convertCartIntoOrderDetailListByCustomerId(String customerId) throws SQLException, NotFoundException{
		 List<OrderDetail> orderDetailList = orderDao.convertCartIntoOrderDetailListByCustomerId(customerId);
		 if(orderDetailList == null) throw new NotFoundException("��ٱ��Ͽ� ������ �����ϴ�.");
		 return orderDetailList;
	 }
}
