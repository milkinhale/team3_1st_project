package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.controller.CouponController;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.Cart;
import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
import util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
	private Properties profile = DBUtil.getProFile();

	LiquorDAO liquorDao = new LiquorDAOImpl();
	CouponDAO couponDAO = new CouponDAOImpl();
	
	/////////////////Test//////////////////////////
	public static void main(String[] args) {
		OrderDAOImpl dao = new OrderDAOImpl();
		
//		
//		try {
//			List<Orders> list = dao.orderSelectByCustomerId("KIM");
//			for(Orders o : list) {
//				System.out.println(o);
//				int i = dao.updateOrder(o, "TESTING");
//				System.out.println(i);
//				System.out.println(o);
//				
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		try {
//			List<Orders> list = dao.orderSelectByCustomerId("KIM");
//			for(Orders o : list) {
//				System.out.println(o);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//
//			 Orders orders = new Orders(0, "KIM", null, "����� ���ı�", null,0, 12);
//			 OrderDetail orderDetail = new OrderDetail(0, 2, 0, 1, 0);
//
//			 orders.getOrderDetailList().add(orderDetail);
//			 dao.insertOrder(orders);
//			 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		try {
//			Orders orders = new Orders(25, null, null, null, null, 0);
//			dao.deleteOrder(orders);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		try {
//			dao.deleteOrder(35);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
	}
	/////////////////Test//////////////////////////
	

	@Override
	public List<Orders> orderSelectAll() throws SQLException {
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Orders> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("order.selectAll"));
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
	        	
	        	//�ֹ���ȣ�� �ش��ϴ� ������ ��������
	        	List<OrderDetail> orderDetailList = selectOrderDetail(orders.getOrderNo());//�޼ҵ� ȣ��
	        	
	        	orders.setOrderDetailList(orderDetailList);
	        	list.add(orders);
	        }
		  }finally {
			  DBUtil.dbClose(con, ps, rs);
		  }
		return list;
	}

	@Override
	public List<Orders> orderSelectByCustomerId(String CustomerId) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Orders> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("order.selectByCustomerNo"));
		   ps.setString(1, CustomerId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
	        	
	        	//�ֹ���ȣ�� �ش��ϴ� ������ ��������
	        	List<OrderDetail> orderDetailList = selectOrderDetail(orders.getOrderNo());//�޼ҵ� ȣ��
	        	
	        	orders.setOrderDetailList(orderDetailList);
	        	list.add(orders);
	        }
		  }finally {
			  DBUtil.dbClose(con, ps, rs);
		  }
		return list;
	}

	@Override
	public int updateOrder(int orderNo, String orderStatusMessage) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
				
		String sql = profile.getProperty("order.update");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, orderStatusMessage);
			ps.setInt(2, orderNo);
			
			result = ps.executeUpdate();
			
//			if(result == 0) {
//				System.out.println("FAILED");
//			}else {
//				System.out.println("SUCCESS");
//			}
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	/**
	 * �ֹ� ����
	 * 		�Ǹ��� �޴����� �����ϰų�, 
	 * 		�����ڰ� �ֹ���ҿ��� ����
	 * 		(�ֹ����¿����� ��� ���� ���� üũ!)
	 * */
	@Override
	public int deleteOrder(int orderNo) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		Orders orderActual = this.selectOrderByOrderNo(orderNo);
		String orderStatus = orderActual.getOrderStatus();
		
		if(orderStatus.equals("����Ȯ����")) {//���� ���̸�
			
			String sql = profile.getProperty("order.delete");
			//System.out.println(sql);
			
			try {
				con = DBUtil.getConnection();
				
				//�ϴ� ���� �ؿ� ���� ���������Ͽ��� ������ �ѹ�, ī��Ʈ ����������ҵ�
				for(OrderDetail orderDetail : orderActual.getOrderDetailList()) {
					//���� ������ �Ѱ��� ������...
					int liquorNo = orderDetail.getLiquorNo();
					int count = orderDetail.getCount();
					//��� �������ִ� �޼ҵ� ȣ��.
					int restoreStock = restoreStock(con, liquorNo, count);
					if(restoreStock==0) throw new SQLException("�ֹ� ��� ����");
				}
				
				ps = con.prepareStatement(sql);
	
				ps.setInt(1, orderNo);
				result = ps.executeUpdate();
				
				
			}finally {
				DBUtil.dbClose(con, ps);
			}
		}
		else {
			throw new SQLException("����Ȯ���� �ƴ�. �ֹ� ��� �Ұ�.");
		}
		return result;
	}
	
	public int restoreStock(Connection con, int liquorNo, int count) throws SQLException{
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = profile.getProperty("orderDetail.selectStockByLiquorNo");
		
		int CurrentCount = 0;
		int updateCount = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, liquorNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				CurrentCount = rs.getInt(1);
				result = 1;
				
				updateCount = CurrentCount + count;
				LiquorDAO liquorDao = new LiquorDAOImpl();
				Liquor liquor = new Liquor();
				liquor.setLiquorNo(liquorNo);
				liquor.setStock(updateCount);
				
				liquorDao.updateStock(liquor);
				//System.out.println("updateCount:" + updateCount);
			}
			
			
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		
		return result;
	}

	 /**
	  * �ֹ� ��ȣ�� �ֹ� ���� ��������.
	  * */
	 public Orders selectOrderByOrderNo(int orderNo) throws SQLException{
		 Orders returnVal = null;
		 
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 
		 String sql = profile.getProperty("order.selectOrderByOrderNo");
		 //select customer_id, order_date, order_addr, order_status, final_price, DISCOUNT from orders where order_no=?

		 
		 try {
			 con = DBUtil.getConnection();
			 ps = con.prepareStatement(sql);
			 
			 ps.setInt(1, orderNo);
			 
			 rs = ps.executeQuery();
			 
			 if(rs.next()) {
				// System.out.println("true");
				 String customerId = rs.getString(1);
				 String orderDate = rs.getString(2);
				 String orderAddr = rs.getString(3);
				 String orderStatus = rs.getString(4);
				 int finalPrice = rs.getInt(5);
				 List <OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
				 orderDetailList = this.selectOrderDetail(orderNo) ;
				 int discount = rs.getInt(6);
				 
				 returnVal = new Orders(orderNo, customerId, orderDate, orderAddr, orderStatus,
							finalPrice, discount, orderDetailList);
			 }

			 //System.out.println("false");	 
					 
		 }finally {
			 DBUtil.dbClose(con, ps, rs);
		 }
		
		 
		 return returnVal;
	 }

	/**
	 * �ֹ���ȣ�� �ش��ϴ� �ֹ��� ��������
	 * */
	public List<OrderDetail> selectOrderDetail(int orderNo)throws SQLException{
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<OrderDetail> list = new ArrayList<>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement(profile.getProperty("orderDetail.selectByOrderNo"));
		   ps.setInt(1, orderNo);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	OrderDetail orderDetail  = new OrderDetail(rs.getInt(1), rs.getInt(2), 
	        			rs.getInt(3), rs.getInt(4), rs.getInt(5));
	        	list.add(orderDetail);
	        }
    }finally {
    	DBUtil.dbClose(con, ps, rs);
    }
		return list;
		
	}
	

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
	@Override
	public int insertOrder(Orders order) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  String sql=profile.getProperty("order.insert");
		  //INSERT INTO ORDERS (ORDER_NO, ORDER_DATE, ORDER_ADDR, FINAL_PRICE, CUSTOMER_ID) VALUES(ORDER_NO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?);
		  //ORDER_ADDR, FINAL_PRICE, CUSTOMER_ID
//setString   1            2              3
		  int result=0;
		 try {
			
		   con = DBUtil.getConnection();
		   con.setAutoCommit(false);  //���� Ŀ�� ����!!
		   
		   int totalAmount = this.getTotalAmount(order);
		   
		   ps = con.prepareStatement(sql);
		   ps.setString(1, order.getOrderAddr());
		   ps.setInt(2, this.getTotalAmount(order));//�ѱ��űݾױ��ϴ� �޼ҵ� ȣ��
		   ps.setString(3, order.getCustomerId());
		   ps.setInt(4, order.getDiscount());
		   
		   result = ps.executeUpdate();
		   
		   int seq = getSeq(con);
		   
//		   System.out.println("seq: " + seq);
		   
		   if(result==0) {
			   con.rollback();
			   throw new SQLException("�ֹ� ����...");
		   }
		   else {
			   //////////////////////////
//			   System.out.println("�ֹ��� ����ϱ�");
			   //////////////////////////
			   int re [] = orderDetailInsert(con, order, seq); //�ֹ��� ����ϱ� 
			   ////////////i����/////////////
//			   for(int tmp: re) {
//				   System.out.println(tmp); 
//			   }
			   //////////////////////////////////
			   for(int i : re) {
				   if(i != 1) {//12c �̻�: ����1/����0    11g: ����-2/����0
					   con.rollback();
					   throw new SQLException("�ֹ� �Ҽ� �����ϴ�....");
				   }
			   }
			   //�ֹ�������ŭ ��� �����ϱ�
			   decrementStock(con, order.getOrderDetailList());
			   if(totalAmount > 200000) {
				   CouponController.insertCouponTable(order.getCustomerId(), 20);
			   }
			   con.commit();
		   }
		   
		    }finally {
		  	  con.commit();
		  	  	DBUtil.dbClose(con, ps , null);
		    }
		
		return result;
	}
	/**
	  * �ش� ȸ�� ��ȣ�� �Է��ϰ� ��ٱ��ϸ� ������ü�� ����� ���� ������ ����Ʈ�� ��� ��������.
	  * */
	public List<OrderDetail> convertCartIntoOrderDetailListByCustomerId(String customer_id) throws SQLException, NotFoundException{
		//���� ���������� ����Ʈ�� �ϳ� �����...
		List<OrderDetail> orderList = new ArrayList<OrderDetail>();
		
		//ȸ����ȣ�� īƮ ����Ʈ ��������
		CartDAO cartDao = new CartDAOImpl();
		List<Cart> cartList = cartDao.cartSelectByCustomerId(customer_id);
		
		//īƮ ����Ʈ�� �ִ� ������ �ϳ��� ���� ���� ������ ��ü�� ��ȯ�ϱ�.
		
		for(Cart cart : cartList) {
			//īƮ ����Ʈ�� �ִ� īƮ ��ü���� ���ֹ�ȣ, ���� ������.
			int liquorNo = cart.getLiquorNo();
			int cartCount = cart.getCartCount();
			//���� ������ �������� ���������� ��ü �����...
			OrderDetail orderDetail = new OrderDetail(0,liquorNo,0,cartCount,0);
			//�ֹ��󼼹�ȣ: 0(SQL���� �������� �� ����)
			//���ֹ�ȣ: cart���� �����°�
			//�ֹ���ȣ: 0(SQL���� �������� �� ����)
			//���ְ���: cart���� �����°�
			//����: 0 (insertOrder �޼ҵ忡�� ���ְ�*������ ������� ����)
			
			//������� ���������� ��ü�� ��������Ʈ�� �ϳ��� �־���.(īƮ ����Ʈ�� ���̻� īƮ�� ����������)
			//(��� ���� ������ ����Ʈ�ε� �̸��� �����...)
			orderList.add(orderDetail);
		}
		//for���� ������ orderList���� īƮ���� ��ȯ�� ���� ���� �� ����.	
		
		return orderList;
	}
	/**
	 * Connection  �Է� �ް� ���� ������ ��ȣ ��������
	 * 
	 * */
	public int getSeq(Connection con) throws SQLException{
		int seq = -1;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql=profile.getProperty("order.getSeq");
		//select ORDER_NO_SEQ.currval from dual
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			
		}finally {
	    	DBUtil.dbClose(null, ps , null);
		}
		
		return seq;
	}
	
	/**
	 * �ֹ��� ����ϱ� 
	 * */
	public int[] orderDetailInsert(Connection con  , Orders order, int seq) throws SQLException{

		 ////////////////////////////
//		 System.out.println("orderNo: "+order.getOrderNo());
		 //////////////////////////
		
		  PreparedStatement ps=null;
		  String sql=profile.getProperty("orderDetail.insert");
		  //orderDetail.insert=INSERT INTO ORDER_DETAIL (ORDER_DETAIL_NO, LIQOUR_NO, ORDER_NO, COUNT, ORDER_PRICE) VALUES(ORDER_DETAIL_SEQ.NEXTVAL, ?, ?, ?, ?)
		  //		ORDER_DETAIL_NO, LIQOUR_NO, ORDER_NO, COUNT, ORDER_PRICE
//setString(Ȥ��Int)   ��� ������        1         2      3        4
		  int result [] =null;
		 try {
			  ps = con.prepareStatement(sql);
			  for( OrderDetail orderDetail : order.getOrderDetailList() ) {
				 Liquor liquor = liquorDao.liquorSelectByLiquorNo(orderDetail.getLiquorNo());
				  	 
				   ps.setInt(1, orderDetail.getLiquorNo());//���� ��ȣ
				   ps.setInt(2,  seq);//�ֹ� ��ȣ
				   ps.setInt(3,  orderDetail.getCount());//�ѱ��űݾ�
				   ps.setInt(4,  liquor.getLiquorPrice()*orderDetail.getCount());//�ѱ��űݾ�
				   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
				   ps.clearParameters();
				   
			  }
			  


			  //////////////////
//			  System.out.println(order.getOrderDetailList().toString());
			  //////////////////
			  
			  
			  result = ps.executeBatch();//�ϰ�ó��
		  
		   
		    }finally {
		    	DBUtil.dbClose(null, ps , null);
		    }
		
		return result;
		
	}
	
	/**
	 * ��ǰ���� ��� ���ҽ�ŰŰ
	 * */
	public int[] decrementStock(Connection con , List<OrderDetail> orderLineList)throws SQLException {
		 PreparedStatement ps=null;
		 String sql=profile.getProperty("liquor.updateStock");
		 int result [] =null;
		 try {
		  ps = con.prepareStatement(sql);
		  for( OrderDetail orderDetail : orderLineList ) {
			   ps.setInt(1, orderDetail.getCount());
			   ps.setInt(2, orderDetail.getLiquorNo());
			   
			   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
			   ps.clearParameters();
		  }
		  
		  result = ps.executeBatch();//�ϰ�ó��
		 }finally {
			 DBUtil.dbClose(null, ps, null);
		 }
		
		return result;
	}
	
	/**
	 * ��ǰ �ѱ��űݾ� ���ϱ�
	 * */
	public int getTotalAmount(Orders order) throws SQLException {
		
		
		//������ ���� ��
		List<OrderDetail> orderDetailList= order.getOrderDetailList();
	    int total=0;
		for(OrderDetail detail : orderDetailList) {
			Liquor liquor =liquorDao.liquorSelectByLiquorNo(detail.getLiquorNo());
			if(liquor==null)throw new SQLException("��ǰ��ȣ �����Դϴ�.... �ֹ� ����..");
			else if(liquor.getStock() <  detail.getCount())throw new SQLException("��� �����Դϴ�...");
			
	    	total += detail.getCount() * liquor.getLiquorPrice() ;
	    }
		
		//������ �����ϱ�!		
		total = total * (100 - order.getDiscount())/100; 
		
		return total;
	}
	
	/**
	 * ���� �ѹ��� ������ ���ؿ���.
	 * */
	public int getSalePercentByCouponNo(int couponNo) throws SQLException{
		int salePercent = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("order.getSalePercentByCouponNo");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, couponNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				salePercent = rs.getInt(1);				
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return salePercent;
	}
	
	/**
	 * ���� �ѹ��� �� ���̵� ��������
	 * 
	 * */
	public String getCustomerIdByOrderNo(int orderNo) throws SQLException{
		String customerId=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Connection con = null;
		String sql=profile.getProperty("order.getCustomerIdByOrderNo");
		//select ORDER_NO_SEQ.currval from dual
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				customerId = rs.getString(1);
			}
			
		}finally {
	    	DBUtil.dbClose(con, ps , rs);
		}
		
		return customerId;
	}

	@Override
	public String getOrderStatusByOrderNo(int orderNo) throws SQLException {
		String orderStatus = null;
		
		PreparedStatement ps=null;
		ResultSet rs = null;
		Connection con = null;
		String sql=profile.getProperty("order.getOrderStatusByOrderNo");
		//select ORDER_NO_SEQ.currval from dual
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				orderStatus = rs.getString(1);
			}
			
		}finally {
	    	DBUtil.dbClose(con, ps , rs);
		}
				
		return orderStatus;
	}
	
	
}
