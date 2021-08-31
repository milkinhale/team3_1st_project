package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.Review;
import kosta.mvc.model.service.ReviewService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ReviewController {
	private static ReviewService reviewService = new ReviewService();
	
	/**
	 * ��ü ���� �˻�
	 * */
	public static void reviewSelectAll() {
		try {
			List<Review> reviewList = reviewService.reviewSelectAll();
			EndView.printReivew(reviewList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * �����̵� �ش� ���� ��ȸ
	 * */
	public static void reviewSelectByCustomerId(String customerId) {
		try {
			List<Review> reviewList = reviewService.reviewSelectByCustomerId(customerId);
			EndView.printReviewByCustomerId(reviewList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * ���������� ���� �˻�
	 * */
	public static void reviewSelectByLiquorNo(int liquorNo) {
		try {
			List<Review> reviewList = reviewService.reviewSelectByLiquorNo(liquorNo);
			EndView.printReviewByLiquorNo(reviewList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * ���� ���
	 * */
	public static void insertReview (int liquorNo, String customerId, String content) {
		try {
			reviewService.insertReview(liquorNo, customerId, content);
			EndView.meesegePrint("��ϵǾ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� �����ϱ�
	 * */
	public static void updateReview (String content, int reviewNo) {
		try {
			reviewService.updateReview(content, reviewNo);
			EndView.meesegePrint("�����Ǿ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� ����
	 * */
	public static void deleteReview (int reviewNo) {
		try {
			reviewService.deleteReview(reviewNo);
			EndView.meesegePrint("�����Ǿ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
