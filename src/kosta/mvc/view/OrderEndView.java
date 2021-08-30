package kosta.mvc.view;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dao.LiquorDAO;
import kosta.mvc.model.dao.LiquorDAOImpl;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;

public class OrderEndView {
////////////////////////TEST/////////////////////////////////////////
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Orders orders = new Orders(0, "KIM", null, "����� ���ı�", null,0, 12);
//		 OrderDetail orderDetail1 = new OrderDetail(0, 21, 0, 1, 0);
//		 OrderDetail orderDetail2 = new OrderDetail(0, 22, 0, 1, 0);
//		 OrderDetail orderDetail3 = new OrderDetail(0, 23, 0, 1, 0);
//		 
//		 orders.getOrderDetailList().add(orderDetail1);
//		 orders.getOrderDetailList().add(orderDetail2);
//		 orders.getOrderDetailList().add(orderDetail3);
//		 
//		 List<Orders> orderList = new ArrayList<Orders>();
//		 orderList.add(orders);
//		 
//		 printOrders(orderList, "��ƹ���");
//	}
////////////////////////TEST/////////////////////////////////////////

	/**
	 * ȸ���� �ֹ� �󼼺���
	 * */
	public static void printOrders(List<Orders> orderList, String customerName) {
	   for(Orders order : orderList) {
		   
		   System.out.println("�ֹ���ȣ: " + order.getOrderNo()+ " | " + "�ֹ�����: "+ order.getOrderDate() +" | " + "�ֹ� �� �ݾ�: "+order.getFinalPrice() +" | "+"��� �ּ�: " + order.getOrderAddr() +" | " +"�ֹ��ڸ�: "+ customerName + " | "+ "�ֹ�����: " + order.getOrderStatus());
		   for(OrderDetail orderDetail : order.getOrderDetailList()) {
			   String liquorName = null;
			   try {
					LiquorDAO liquorDao = new LiquorDAOImpl();
					Liquor liquor = liquorDao.liquorSelectByLiquorNo(orderDetail.getLiquorNo());
					liquorName = liquor.getLiquorName();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			   System.out.println("  �� �ֹ��� ����: "+ liquorName + " | ����: " + orderDetail.getCount() + " | �ݾ�: " + orderDetail.getOrderPrice());

		   }
		   System.out.println();
	   }
		
	}
	/**
	 * ��� �ֹ� �󼼺���
	 * */
	public static void printAllOrders(List<Orders> orderList) {
	   for(Orders order : orderList) {
		   
		   System.out.println("�ֹ���ȣ: " + order.getOrderNo()+ " | " + "�ֹ�����: "+ order.getOrderDate() +" | " + "�ֹ� �� �ݾ�: "+order.getFinalPrice() +" | "+"��� �ּ�: " + order.getOrderAddr() +" | " +"�ֹ���ID: "+ order.getCustomerId() + " | "+ "�ֹ�����: " + order.getOrderStatus());
		   for(OrderDetail orderDetail : order.getOrderDetailList()) {
			   String liquorName = null;
			   try {
					LiquorDAO liquorDao = new LiquorDAOImpl();
					Liquor liquor = liquorDao.liquorSelectByLiquorNo(orderDetail.getLiquorNo());
					liquorName = liquor.getLiquorName();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			   System.out.println("  �� �ֹ��� ����: "+ liquorName + " | ����: " + orderDetail.getCount() + " | �ݾ�: " + orderDetail.getOrderPrice());
		   }
		   System.out.println();
	   }
		
	}
}
