package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
import util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
	private Properties profile = DBUtil.getProFile();

	LiquorDAO liquorDao = new LiquorDAOImpl();
	
	/////////////////Test//////////////////////////
	public static void main(String[] args) {
		OrderDAOImpl dao = new OrderDAOImpl();
		
		
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
		
		try {

			 Orders orders = new Orders(0, "KIM", null, "����� ���ı�", null, 0);
			 OrderDetail orderDetail = new OrderDetail(0, 1, 0, 1, 0);
			 
			 dao.insertOrder(orders);
			 orders.getOrderDetailList().add(orderDetail);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
	        	
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
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
	        	
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
	public int updateOrder(Orders order, String orderStatusMessage) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int orderNo = order.getOrderNo();
		
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
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int deleteOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
		   
		   ps = con.prepareStatement(sql);
		   ps.setString(1, order.getOrderAddr());
		   ps.setInt(2, this.getTotalAmount(order));//�ѱ��űݾױ��ϴ� �޼ҵ� ȣ��
		   ps.setString(3, order.getCustomerId());
		   
		   result = ps.executeUpdate();
		   if(result==0) {
			   con.rollback();
			   throw new SQLException("�ֹ� ����...");
		   }
		   else {
			   int re [] = orderDetailInsert(con, order); //�ֹ��� ����ϱ� 
			   ////////////i����/////////////
			   for(int i : re) {
				   System.out.println(i); 
			   }
			   //////////////////////////////////
			   for(int i : re) {
				   if(i != 1) {//12c �̻�: ����1/����0    11g: ����-2/����0
					   con.rollback();
					   throw new SQLException("�ֹ� �Ҽ� �����ϴ�....");
				   }
			   }
			   
			   //�ֹ�������ŭ ��� �����ϱ�
			   decrementStock(con, order.getOrderDetailList());
			   con.commit();
		   }
		   
		    }finally {
		  	  con.commit();
		  	  	DBUtil.dbClose(con, ps , null);
		    }
		
		return result;
	}
	
	/**
	 * �ֹ��� ����ϱ� 
	 * */
	public int[] orderDetailInsert(Connection con  , Orders order) throws SQLException{
		
		  PreparedStatement ps=null;
		  String sql=profile.getProperty("orderDetail.insert");
		  //INSERT INTO ORDER_DETAIL (ORDER_DETAIL_NO, LIQOUR_NO, ORDER_NO, COUNT, ORDER_PRICE) VALUES(ORDER_DETAIL_NO_SEQ.NEXTVAL, ?, ?, ?, ?);
		  //		LIQOUR_NO, ORDER_NO, COUNT, ORDER_PRICE
//setString(Ȥ��Int)   1          2        3       4
		  int result [] =null;
		 try {
			 ps = con.prepareStatement(sql);
		  for( OrderDetail orderDetail : order.getOrderDetailList() ) {
			 Liquor liquor = liquorDao.liquorSelectByLiquorNo(orderDetail.getLiquorNo());
			  
			 ////////////////////////////
			 System.out.println("orderNo"+order.getOrderNo());
			 //////////////////////////
			 
			 
			   ps.setInt(1, orderDetail.getLiquorNo());//���� ��ȣ
			   ps.setInt(2, order.getOrderNo());//�ֹ� ��ȣ
			   ps.setInt(3,  orderDetail.getCount());//�ѱ��űݾ�
			   ps.setInt(4,  liquor.getLiquorPrice()*orderDetail.getCount());//�ѱ��űݾ�
			   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
			   ps.clearParameters();
			   
		  }
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
		List<OrderDetail> orderDetailList= order.getOrderDetailList();
	    int total=0;
		for(OrderDetail detail : orderDetailList) {
			Liquor liquor =liquorDao.liquorSelectByLiquorNo(detail.getLiquorNo());
			if(liquor==null)throw new SQLException("��ǰ��ȣ �����Դϴ�.... �ֹ� ����..");
			else if(liquor.getStock() <  detail.getCount())throw new SQLException("��� �����Դϴ�...");
			
	    	total += detail.getCount() * liquor.getLiquorPrice() ;
	    }
		return total;
	}
}
