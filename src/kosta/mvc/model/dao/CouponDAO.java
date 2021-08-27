package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Coupon;

public interface CouponDAO {
	/**
	 * 쿠폰 리스트 보여주기
	 * */
	List<Coupon> couponSelectAll(int customerId) throws SQLException;
	
	/**
	 * 사용할 쿠폰 보여주기
	 * */
	Coupon couponSelectByCouponNo(int customerId, int couponId) throws SQLException;
	
	/**
	 * 쿠폰 등록하기
	 * */
	int insertCoupon(Coupon coupon) throws SQLException;
	
	/**
	 * 쿠폰 사용하기
	 * */
	int useCoupon(Coupon coupon) throws SQLException;
}
