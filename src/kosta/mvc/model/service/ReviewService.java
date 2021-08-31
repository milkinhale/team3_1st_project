package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.Review;

public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	/**
	 * ��ü ���� ��ȸ
	 * */
	public List<Review> reviewSelectAll() throws SQLException {
		List<Review> reviewList = reviewDAO.reviewSelectAll();
		if(reviewList == null || reviewList.isEmpty()) {
			throw new SQLException("��ϵ� ���䰡 �����ϴ�.");
		}
		
		return reviewList;
	}
	
	/**
	 * �����̵� �ش� ���� ��ȸ
	 * */
	public List<Review> reviewSelectByCustomerId(String customerId) throws NotFoundException, SQLException{
		List<Review> list = reviewDAO.reviewSelectByCustomerId(customerId);
		if(list.size()==0)throw new NotFoundException("�ش� ȸ�����̵� �����ϴ� ���䰡 �����ϴ�.");
		return list;
	}
	
	/**
	 * ���� ������ ���� ��ȸ
	 * */
	public List<Review> reviewSelectByLiquorNo(int liquorNo) throws NotFoundException, SQLException {
		List<Review> reviewList = reviewDAO.reviewSelectByLiquorNo(liquorNo);
		if(reviewList == null) {
			throw new SQLException("�ش� �����ȣ�� ��ϵ� ���䰡 �����ϴ�.");
		}
		
		return reviewList;
	}
	
	/**
	 * ���� ���
	 * */
	public void insertReview(int liquorNo, String customerId, String content) throws SQLException {
		int result = reviewDAO.insertReview(liquorNo, customerId, content);
		if(result == 0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");

	}
	
	/**
	 * ���� ����
	 * */
	public void updateReview(String content, int reviewNo)throws SQLException {
		int result = reviewDAO.updateReview(content, reviewNo);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");
	}
	
	/**
	 * �ش� �����ȣ�� �ش��ϴ� ���� ����
	 * */
	public void deleteReview(int reviewNo) throws SQLException {
		int result = reviewDAO.deleteReview(reviewNo);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");

	}

}
