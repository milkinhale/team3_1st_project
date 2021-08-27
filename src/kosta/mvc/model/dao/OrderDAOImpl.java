package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
import util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
	private Properties profile = DBUtil.getProFile();
	
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
		
		try {
			List<Orders> list = dao.orderSelectByCustomerId("KIM");
			for(Orders o : list) {
				System.out.println(o);
			}
		}catch(Exception e) {
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
	
	@Override
	public int insertOrder(Orders order) throws SQLException {
		Connection con=null;
		  PreparedStatement ps=null;
		  String sql="INSERT INTO ORDERS(ORDER_ID, ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)" + 
		  		"  VALUES(ORDER_ID_SEQ.NEXTVAL ,sysdate,?,?, ?)";
		  int result=0;
		 try {
			
		   con = DBUtil.getConnection();
		   con.setAutoCommit(false);  //���� Ŀ�� ����!!
		   
		   ps = con.prepareStatement(sql);
//		   ps.setString(1, order.getUserId());
//		   ps.setString(2, order.getAddress());
//		   ps.setInt(3, this.getTotalAmount(order));//�ѱ��űݾױ��ϴ� �޼ҵ� ȣ��
		   
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
		  int result [] =null;
		 try {
			 ps = con.prepareStatement(sql);
		  for( OrderDetail orderDetail : order.getOrderDetailList() ) {
//			 Goods goods = goodsDao.goodsSelectBygoodsId(orderline.getGoodsId());
//			  
//			   ps.setString(1, orderline.getGoodsId());
//			   ps.setInt(2, goods.getGoodsPrice());//����
//			   ps.setInt(3, orderline.getQty());//�ѱ��űݾ�
//			   ps.setInt(4,  goods.getGoodsPrice()*orderline.getQty());//�ѱ��űݾ�
//			   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
//			   ps.clearParameters();
			   
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
		  String sql="update goods set stock = stock-? where goods_id=?";
		  int result [] =null;
		 try {
		  ps = con.prepareStatement(sql);
		  for( OrderDetail orderDetail : orderLineList ) {
//			   ps.setInt(1, orderDetail.getQty());
//			   ps.setString(2, orderDetail.getGoodsId());
			   
			   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
			   ps.clearParameters();
		  }
		  
		  result = ps.executeBatch();//�ϰ�ó��
		 }finally {
			 DBUtil.dbClose(null, ps, null);
		 }
		
		return result;
	}
}
