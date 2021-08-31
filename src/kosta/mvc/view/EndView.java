package kosta.mvc.view;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dto.Cart;
import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.dto.Review;

public class EndView {
  /**
   * ��ǰ ��ü ���
   * */
	/*public static void printGoodsList(List<Goods> list) {
		System.out.println("-----��ǰ "+ list.size() +"�� -------------");
		for(Goods goods : list) {
			System.out.println(goods);
		}
		
		System.out.println();
	}*/
	
	
	
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printCouponList(List<Coupon> couponList) {
		for(Coupon coupon : couponList) {
			System.out.println(coupon);
		}
	}

	public static void printCoupon(Coupon coupon) {
		System.out.println(coupon);
	}
	
	//Review, Cart
	/**
	 * ��ü ���� ��ȸ
	 * */
	public static void printReivew(List<Review> reviewList){
		System.out.println("--�� ���� �� : " + reviewList.size()+ "�� ----");
		for(Review r : reviewList) {
			System.out.println(r);
		}
		System.out.println();
	}
	
	/**
	 * �����̵� �ش� ���� ��ȸ
	 * */
	public static void printReviewByCustomerId(List<Review> reviewList){
		for(Review r : reviewList) {
			System.out.println(r);
		}
		System.out.println();
		
	}
	
	/**
	 * ���������� ���� �˻�
	 * */
	public static void printReviewByLiquorNo(List<Review> reviewList){
		for(Review r : reviewList) {
			System.out.println(r);
		}
		System.out.println();
		
	}
	
	/**
	 * �������� �� �޼��� ���
	 * */
	public static void meesegePrint(String message) {
		System.out.println(message);
	}
	
	/**
	 * �����̵� ��ٱ��� ��ȸ
	 * */
	public static void printCartByCustomerId(List<Cart> cartList) {
		for(Cart r : cartList) {
			System.out.println(r);
		}
		System.out.println();
	}//Review cart ��
	
	/**
	 * ��ٱ��� ����
	 * */
	/*public static void printViewCart(String id , Map<Goods,Integer> cart) {
		System.out.println("��ٱ��ϳ���....");
		
		for(Goods goods: cart.keySet()) { //��� Key�� ������ 
			String goodsId = goods.getGoodsId();//��ǰ��ȣ
			String name = goods.getGoodsName();//��ǰ�̸�
			int price = goods.getGoodsPrice();//��ǰ����
			
			int quantity = cart.get(goods);//
			System.out.println(goodsId + " : "+name+" : " + price + " \t " + quantity);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.�ֹ��ϱ�  |  9.������");
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			
			 System.out.print("����ּ� : ");
			 String address = sc.nextLine();
			
			 Orders orders = new Orders(0, null, id, address, 0);
			 
			 List<OrderLine> orderLineList = orders.getOrderLineList();
			 
			 for(Goods goodsKey : cart.keySet()) {
				 int qty = cart.get(goodsKey);
				 OrderLine orderLine = new OrderLine(0, 0, goodsKey.getGoodsId() , 0, qty, 0);
				 orderLineList.add(orderLine);
			 }
			 
			 System.out.println("orderLineList ���� : " + orderLineList.size());
			 OrderController.insertOrders(orders);
			 
			 //��ٱ��Ϻ���
			 SessionSet ss = SessionSet.getInstance();
			 Session session = ss.get(id);
			 session.removeAttribute("cart");
			break;
			
		case 9:
			break;
		}
		
		//System.out.println(id);
	
	}*/
 
	/**
	 * ȸ���� �ֹ� �󼼺���
	 * */
//	public static void printOrders(List<Orders> orderList, String customerName) {
//	   for(Orders order : orderList) {
//		   
//		   System.out.println(order.getOrderNo()+ " | " + order.getOrderDate() +" | " + order.getFinalPrice() +" | " + order.getOrderAddr() +" | " + customerName);
//		   for(OrderDetail orderDetail : order.getOrderDetailList()) {
//			   System.out.println("  �� "+orderDetail);
//		   }
//		   System.out.println();
//	   }
//		
//	}
	/**
	 * ��� �ֹ� �󼼺���
	 * */
//	public static void printAllOrders(List<Orders> orderList) {
//	   for(Orders order : orderList) {
//		   
//		   System.out.println(order.getOrderNo()+ " | " + order.getOrderDate() +" | " + order.getFinalPrice() +" | " + order.getOrderAddr() +" | " + order.getCustomerId());
//		   for(OrderDetail orderDetail : order.getOrderDetailList()) {
//			   System.out.println("  �� "+orderDetail);
//		   }
//		   System.out.println();
//	   }
//		
//	}
}












