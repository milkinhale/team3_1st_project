package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.service.OrderService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class OrderController {
    private static OrderService orderService = new OrderService();
	
    /**
	 * �ֹ� ���� ��ü ����
	 * 		�Ǹ��ڿ�޴����� �����.
	 * */
	public static void orderSelectAll(){
		try {
			 List<Orders> orderList = orderService.orderSelectAll();
			 EndView.printOrders(orderList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	
	}
	
    /**
	 * ȸ���� �ֹ� ���� ����
	 * */
	public static void selectOrdersByUserId(String customerId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(customerId);
             EndView.printOrders(orderList);
		}catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��ڰ� �ֹ����� �����Ҷ� �����.
	 * */
	public static void updateOrder(Orders order, String orderStatusMessage) {
		try {
			orderService.updateOrder(order, orderStatusMessage);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
    
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	public static void deleteOrder(Orders order){
		try {
			orderService.deleteOrder(order);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
    /**
	 * �ֹ��ϱ�
	 * */
	public static void insertOrders(Orders order) {
		try {
		  orderService.insertOrders(order);
		}catch (Exception e) {
			e.printStackTrace();
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
			 
			 
			 EndView.printOrders(orderList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());		
		}
	 }
	
	
}




