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
	List<Review> reviewSelectByLiquorNo(int liquorNo) throws SQLException;
	
	/**
	 * ���� ���
	 * */
	int insertReview(int liquorNo, String customerId, String content) throws SQLException;
	
	
	/**
	 * ���� �����ϱ�
	 * */
	int updateReview(String content, int reviewNo) throws SQLException;

	
	/**
	 * ���� �����ϱ�  -> ���� ��ȣ�� �޾Ƽ�
	 * �ش� �����ȣ�� �ش��ϴ� ���� ����
	 * */
	int deleteReview(int reviewNo) throws SQLException;

	
	
	
	
}
