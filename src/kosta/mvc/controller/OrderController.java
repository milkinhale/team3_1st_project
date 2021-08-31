package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dao.OrderDAO;
import kosta.mvc.model.dao.OrderDAOImpl;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.service.OrderService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.OrderEndView;

public class OrderController {
    private static OrderService orderService = new OrderService();
    private static CustomerDAO customerDao = new CustomerDAOImpl();
    private static OrderDAO orderDao = new OrderDAOImpl();
	
    /**
	 * �ֹ� ���� ��ü ����
	 * 		�Ǹ��ڿ�޴����� �����.
	 * */
	public static void orderSelectAll(){
		try {
			 List<Orders> orderList = orderService.orderSelectAll();
			 OrderEndView.printAllOrders(orderList);
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	
	}
	
    /**
	 * ȸ���� �ֹ� ���� ����
	 * */
	public static void selectOrdersByUserId(String customerId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(customerId);
			 String customerName = customerDao.findCustomerName(customerId);
			 OrderEndView.printOrders(orderList, customerName);
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��ڰ� �ֹ����� �����Ҷ� �����.
	 * */
	public static void updateOrder(int orderNo, String orderStatusMessage) {
		try {
			orderService.updateOrder(orderNo, orderStatusMessage);
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
    
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	public static void deleteOrder(int orderNo){
		try {
			orderService.deleteOrder(orderNo);
			EndView.meesegePrint("�ֹ���ȣ" + orderNo + "���� ��ҵǾ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
    /**
	 * �ֹ��ϱ�
	 * */
	public static void insertOrders(Orders order, int couponNo) {
		try {
		orderService.insertOrders(order, couponNo);
		EndView.meesegePrint("�ֹ��� �Ϸ�Ǿ����ϴ�!");
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());			
		}
	}
	
	/**
	  * �ֹ� ��ȣ�� �ֹ� ���� ��������.
	  * */
	 public static void selectOrderByOrderNo(int orderNo){
		 try {
			 
			 List<Orders> orderList = new ArrayList<Orders>();
			 Orders order = orderService.selectOrderByOrderNo(orderNo);
			 orderList.add(order);
			 String customerId = orderDao.getCustomerIdByOrderNo(orderNo);
			 String customerName = customerDao.findCustomerName(customerId);

			 OrderEndView.printOrders(orderList, customerName);
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());		
		}
	 }
	 
	 /**
	  * ��ٱ��Ϸ� �ֹ��ϱ�.
	  * */
	 public static void OrderCart(String customerId, String addr, int couponNo){
		 try {
			 //�ϴ� ���� ��ü�� �ϳ� ����.
			 Orders order = new Orders(0, customerId, null, addr, null, 0, 0);
			 //�ֹ���ȣ : 0(sql���� �������� ������)
			 //ȸ����ȣ : �Է¹��� ��ȣ (���ǰ�ü���� �����;ߵ�)
			 //�ֹ����� : null (sql���� sysdate���� ������)
			 //����ּ� : �Է¹��� �ּ� (��ĳ�ʷ� �Է¹޾Ƽ� �־������)
			 //�ֹ����� : null (sql���� default������ ������)
			 //�������� : 0 (DAO���� ������� ����)
			 
			 //���񽺿��� ���������� ����Ʈ ��������
			 List<OrderDetail> list = orderService.convertCartIntoOrderDetailListByCustomerId(customerId);
			 
			 //���񽺿��� ������ ������������ �ϳ��� ������... 
			 for(OrderDetail detail : list) {
				 //������ ���� ���� ���� ��ü�� ���������� ����Ʈ�� �ϳ��� �־���.
				 order.getOrderDetailList().add(detail);				 
			 }
			 //�ϼ��� ���� ��ü�� ������ �ֹ��ϱ� �޼ҵ�� ����.	 
			 orderService.insertOrders(order, couponNo);
		 } catch (Exception e) {
			// e.printStackTrace();
			 FailView.errorMessage(e.getMessage());	
		 }
	 }
	
	
}




