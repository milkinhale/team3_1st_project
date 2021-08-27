package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {
	/**
	 * ��ü ���� ��ȸ
	 * */
	List<Review> reviewSelectAll() throws SQLException;
	
	/**
	 * ȸ���� ���� ��ȸ
	 *  �Ǹ��ڿ� �޴����� ����� ����
	 * */
	List<Review> reviewSelectByCustomerId(String customerId) throws SQLException;
	
	/**
	 * ����������(���ֹ�ȣ��) ���� ��ȸ
	 *  �Ǹ��ڿ� �޴����� ����� ����
	 * */
	List<Review> reviewSelectByLiquorNo(String liqourtype) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * */
	int insertReview(Review review) throws SQLException;
	
	
	/**
	 * ���� �����ϱ� -> ���� ��ȣ�� �޾Ƽ�?
	 * ���� �����ȣ�� �ش��ϴ� ���� ����?
	 *  �Ǹ��� �޴����� ���
	 * */
	int updateReview(Review review) throws SQLException;
	
	/**
	 * ���� �����ϱ�  -> ���� ��ȣ�� �޾Ƽ�
	 * �ش� �����ȣ�� �ش��ϴ� ���� ����
	 * */
	int deleteReview(Review review) throws SQLException;
	
	
}
