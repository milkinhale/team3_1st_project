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
			EndView.printReviewByCustomerId(reviewList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * ���� ���
	 * */
	public static void insertReview (Review reviewdto) {
		try {
			reviewService.insertReview(reviewdto);
			EndView.meesegePrint("��ϵǾ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� ����
	 * */
	public static void deleteReview (Review reviewdto) {
		try {
			reviewService.insertReview(reviewdto);
			EndView.meesegePrint("�����Ǿ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
