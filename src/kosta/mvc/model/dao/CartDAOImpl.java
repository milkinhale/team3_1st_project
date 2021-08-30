package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Cart;
import kosta.mvc.model.dto.Review;
import util.DBUtil;

public class CartDAOImpl implements CartDAO {
	private Properties proFile = DBUtil.getProFile();
	
	//테스트
	public static void main(String[] args) {
		CartDAOImpl dao = new CartDAOImpl();
		try {
			
			//장바구니 전체 조회하기
			System.out.println("장바구니 전체 조회하기");
			List<Cart> cart2 = dao.cartSelectAll();
			if (cart2 != null) {
				for(Cart ca : cart2) {
					System.out.println(ca);
				}
			}
			
			//회원id별로 장바구니 조회하기
			System.out.println("****회원id별로 장바구니 조회하기 test***");
			List<Cart> cart1 = dao.cartSelectByCustomerId("CHOI1");
			if(cart1 != null) {
				for(Cart c : cart1) {
					System.out.println(c);
				}
			}
			
			
			System.out.println("****장바구니 삭제하기test *****");
			System.out.println(dao.deleteCart("JANG"));

			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	///////////테스트////////////

	/**
	 * 장바구니 전체 조회하기
	 * */
	
	@Override
	public List<Cart> cartSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Cart> cartList = new ArrayList<Cart>();
		String sql = proFile.getProperty("cart.select"); //이것을 외
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Cart cartDto = new Cart(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				cartList.add(cartDto);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return cartList;
	}
	
	/**
	 * 회원id별로 장바구니 조회하기
	 * */
	@Override
	public List<Cart> cartSelectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Cart> cartList = new ArrayList<Cart>();
		String sql = proFile.getProperty("cart.selectByCustomerId"); //이것을 외
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			if(rs.next()) {
				Cart cartDto = new Cart(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				cartList.add(cartDto);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return cartList;
	}

	
	/**
	 * 장바구니 담기
	 * */
	@Override
	public int insertCart(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("cart.insertCart");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cart.getCustomerId());
			ps.setInt(2, cart.getLiquorNo());
			ps.setInt(3, cart.getCartCount());
		
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}


	/**
	 * 회원ID를 입력해서 장바구니 삭제하기 
	 * */
	@Override
	public int deleteCart(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("cart.deleteCart");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setString(1, customerId);

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
