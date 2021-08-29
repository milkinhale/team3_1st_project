package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.service.CouponService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class CouponController {
	private static CouponService couponService = new CouponService();
	

	/**
	 * ���� ����Ʈ �����ֱ�
	 * */
	public static void  couponSelectAll(String customerId) {
		try {
			List<Coupon> couponList = couponService.couponSelectAll(customerId);
			EndView.printCouponList(couponList);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ����� ���� �����ֱ�
	 * */
	public static void couponSelectByCouponNo(String customerId, int couponNo) {
		try {
			Coupon coupon = couponService.couponSelectByCouponNo(customerId, couponNo);
			EndView.printCoupon(coupon);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �������̺� ����ϱ�
	 * */
	public static void insertCouponTable(String customerId, int salePercent) {
		try {
			couponService.insertCouponTable(customerId, salePercent);
			EndView.printMessage("������ ��ϵǾ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� ����ϱ�
	 * */
	public static void useCoupon(Coupon coupon) {
		try {
			couponService.useCoupon(coupon);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
