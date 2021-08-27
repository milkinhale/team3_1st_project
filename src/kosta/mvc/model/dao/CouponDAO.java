package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Coupon;

public interface CouponDAO {
	/**
	 * ���� ����Ʈ �����ֱ�
	 * */
	List<Coupon> couponSelectAll(int customerId) throws SQLException;
	
	/**
	 * ����� ���� �����ֱ�
	 * */
	Coupon couponSelectByCouponNo(int customerId, int couponId) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * */
	int insertCoupon(Coupon coupon) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * */
	int useCoupon(Coupon coupon) throws SQLException;
}
