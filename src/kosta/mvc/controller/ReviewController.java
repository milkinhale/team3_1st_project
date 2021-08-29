package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.Review;
import kosta.mvc.model.service.ReviewService;
import kosta.mvc.view.FailView;
import kosta.mvc.view.ReviewCartEndview;

public class ReviewController {
	private static ReviewService reviewService = new ReviewService();
	
	/**
	 * ��ü ���� �˻�
	 * */
	public static void reviewSelectAll() {
		try {
			List<Review> reviewList = reviewService.reviewSelectAll();
			ReviewCartEndview.printReivew(reviewList);
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
			ReviewCartEndview.printReviewByCustomerId(reviewList);
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
			ReviewCartEndview.printReviewByCustomerId(reviewList);
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
			ReviewCartEndview.meesegePrint("��ϵǾ����ϴ�.");
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
			ReviewCartEndview.meesegePrint("�����Ǿ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
