package kosta.mvc.controller;

import kosta.mvc.model.service.OrderService;

public class OrderController {
    private static OrderService orderService = new OrderService();
	/**
	 * 주문하기
	 * */
	/*public static void insertOrders(Orders order) {
		try {
		  orderService.insertOrders(order);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}*/
	
	/**
	 * 주문내역보기
	 * */
	/*public static void selectOrdersByUserId(String userId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(userId);
             EndView.printOrderByUserId(orderList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}*/
}




