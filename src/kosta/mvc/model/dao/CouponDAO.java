package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Coupon;
import kosta.mvc.model.dto.CouponTable;

public interface CouponDAO {
	/**
	 * ���� ����Ʈ �����ֱ�
	 * */
	List<Coupon> couponSelectAll(String customerId) throws SQLException;
	
	/**
	 * ����� ���� �����ֱ�
	 * */
	Coupon couponSelectByCouponNo(String customerId, int couponNo) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * */
	int insertCoupon(Connection con, int salePercent, int seq) throws SQLException;
	
	/**
	 * �������̺� ����ϱ�
	 * */
	int insertCouponTable(String customerId, int salePercent) throws SQLException;
	
	/**
	 * ���糯¥�� ���� �ҷ�����
	 * */
	boolean couponSelectBySysdate(Connection con, String customerId) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * */
	int useCoupon(int couponNo) throws SQLException;
	
	/**
	 * Connection  �Է� �ް� ���� ������ ��ȣ ��������
	 * */
	int getSeq(Connection con) throws SQLException;
}
