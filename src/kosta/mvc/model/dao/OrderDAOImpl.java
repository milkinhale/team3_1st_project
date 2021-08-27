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
		
		
		try {
			List<Orders> list = dao.orderSelectAll();
			for(Orders o : list) {
				System.out.println(o);
			}
			
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
	        	
	        	//주문번호에 해당하는 상세정보 가져오기
	        	List<OrderDetail> orderDetailList = selectOrderDetail(orders.getOrderNo());//메소드 호출
	        	
	        	orders.setOrderLineList(orderDetailList);
	        	list.add(orders);
	        }
		  }finally {
			  DBUtil.dbClose(con, ps, rs);
		  }
		return list;
	}

	@Override
	public List<Orders> orderSelectByCustomerNo(String customerId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 주문번호에 해당하는 주문상세 가져오기
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
}
