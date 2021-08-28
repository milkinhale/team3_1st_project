package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Cart;
import util.DBUtil;

public class CartDAOImpl implements CartDAO {
	private Properties proFile = DBUtil.getProFile();

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
		
		return null;
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
	 * 장바구니번호를 입력해서 장바구니 삭제하기 
	 * */
	@Override
	public int deleteCart(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("cart.deleteCart");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setInt(1, cart.getCartNo());

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
