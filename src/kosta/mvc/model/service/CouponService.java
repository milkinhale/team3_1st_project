package kosta.mvc.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CouponDAO;
import kosta.mvc.model.dao.CouponDAOImpl;
import kosta.mvc.model.dto.Coupon;

public class CouponService {
	CouponDAO couponDAO = new CouponDAOImpl();
	
	/**
	 * ���� ����Ʈ �����ֱ�
	 * */
	public List<Coupon>  couponSelectAll(String customerId) throws SQLException, NotFoundException {
		List<Coupon> couponlist = couponDAO.couponSelectAll(customerId);
		if(couponlist.size() == 0) throw new NotFoundException("������ �����ϴ�");
		return couponlist;
	}
	
	/**
	 * ����� ���� �����ֱ�
	 * */
	public Coupon couponSelectByCouponNo(String customerId, int couponNo) throws SQLException, NotFoundException {
		Coupon coupon = couponDAO.couponSelectByCouponNo(customerId, couponNo);
		if(coupon == null) throw new NotFoundException(couponNo + "���� �ش��ϴ� ������ �������� �ʽ��ϴ�");
		return coupon;
	}
	
	/**
	 * �������̺� ����ϱ�
	 * */
	public void insertCouponTable(String customerId, int salePercent) throws SQLException, NotFoundException {
		int result = couponDAO.insertCouponTable(customerId, salePercent);
		if(result == 0) throw new NotFoundException("��ϵ��� �ʾҽ��ϴ�");
	}
	
	/**
	 * ���� ����ϱ�
	 * */
	public void useCoupon(Coupon coupon) throws SQLException, NotFoundException {
		int result = couponDAO.useCoupon(coupon);
		if(result == 0) throw new NotFoundException("������ �ʾҽ��ϴ�");
	}
}