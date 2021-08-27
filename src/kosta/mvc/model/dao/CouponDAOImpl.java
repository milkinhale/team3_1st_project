package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Coupon;

public class CouponDAOImpl implements CouponDAO {

	@Override
	public List<Coupon> couponSelectAll(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon couponSelectByCouponNo(int customerId, int couponId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCoupon(Coupon coupon) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int useCoupon(Coupon coupon) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
