package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.dto.CouponTable;

public interface CouponDAO {
	/**
	 * 쿠폰 리스트 보여주기
	 * */
	List<Coupon> couponSelectAll(String customerId) throws SQLException;
	
	/**
	 * 사용할 쿠폰 보여주기
	 * */
	Coupon couponSelectByCouponNo(String customerId, int couponNo) throws SQLException;
	
	/**
	 * 쿠폰 등록하기
	 * */
	int insertCoupon(int salePercent) throws SQLException;
	
	/**
	 * 쿠폰테이블 등록하기
	 * */
	int insertCouponTable(String customerId) throws SQLException;
	
	/**
	 * 쿠폰 사용하기
	 * */
	int useCoupon(Coupon coupon) throws SQLException;
}
