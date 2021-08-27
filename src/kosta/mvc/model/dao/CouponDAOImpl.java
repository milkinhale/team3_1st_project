package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.dto.CouponTable;
import util.DBUtil;

public class CouponDAOImpl implements CouponDAO {
	
	private Properties proFile = DBUtil.getProFile();

	@Override
	public List<Coupon> couponSelectAll(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Coupon> couponList = new ArrayList<Coupon>();
		String sql = proFile.getProperty("coupon.selectByCustomerId");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Coupon coupon = new Coupon(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				couponList.add(coupon);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return couponList;
	}

	@Override
	public Coupon couponSelectByCouponNo(String customerId, int couponNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Coupon coupon = null;
		String sql = proFile.getProperty("coupon.selectCoupon");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, couponNo);
			ps.setString(2, customerId);
			rs = ps.executeQuery();
			while(rs.next()) {
				coupon = new Coupon(rs.getInt(1));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return coupon;
	}
	
	@Override
	public int insertCouponTable(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("couponTable.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int insertCoupon(int salePercent) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("coupon.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, salePercent);
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int useCoupon(Coupon coupon) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("coupon.updateUsed");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, coupon.getCouponNo());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
}
