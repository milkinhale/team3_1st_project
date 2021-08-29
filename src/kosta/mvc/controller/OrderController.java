package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dao.OrderDAO;
import kosta.mvc.model.dao.OrderDAOImpl;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.service.OrderService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class OrderController {
    private static OrderService orderService = new OrderService();
    private static CustomerDAO customerDao = new CustomerDAOImpl();
    private static OrderDAO orderDao = new OrderDAOImpl();
	
    /**
	 * 주문 내역 전체 보기
	 * 		판매자용메뉴에서 사용함.
	 * */
	public static void orderSelectAll(){
		try {
			 List<Orders> orderList = orderService.orderSelectAll();
			 EndView.printAllOrders(orderList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	
	}
	
    /**
	 * 회원별 주문 내역 보기
	 * */
	public static void selectOrdersByUserId(String customerId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(customerId);
			 String customerName = customerDao.findCustomerName(customerId);
             EndView.printOrders(orderList, customerName);
		}catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 주문 수정
	 * 		판매자가 주문상태 수정할때 사용함.
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
	 * 주문 삭제
	 * 		판매자 메뉴에서 삭제하거나, 
	 * 		구매자가 주문취소에서 삭제
	 * 		(주문상태에따라 취소 가능 여부 체크!)
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
	 * 주문하기
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
	  * 주문 번호로 주문 정보 가져오기.
	  * */
	 public static void selectOrderByOrderNo(int orderNo){
		 try {
			 
			 List<Orders> orderList = new ArrayList<Orders>();
			 Orders order = orderService.selectOrderByOrderNo(orderNo);
			 orderList.add(order);
			 String customerId = orderDao.getCustomerIdByOrderNo(orderNo);
			 String customerName = customerDao.findCustomerName(customerId);

			 EndView.printOrders(orderList, customerName);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());		
		}
	 }
	
	
}




