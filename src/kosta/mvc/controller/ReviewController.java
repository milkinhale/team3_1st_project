package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.Review;
import kosta.mvc.model.service.ReviewService;
import kosta.mvc.view.FailView;
import kosta.mvc.view.ReviewCartEndview;

public class ReviewController {
	private static ReviewService reviewService = new ReviewService();
	
	/**
	 * 전체 리뷰 검색
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
	 * 고객아이디 해당 리뷰 조회
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
	 * 양주종류별 리뷰 검색
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
	 * 리뷰 등록
	 * */
	public static void insertReview (Review reviewdto) {
		try {
			reviewService.insertReview(reviewdto);
			ReviewCartEndview.meesegePrint("등록되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 리뷰 삭제
	 * */
	public static void deleteReview (Review reviewdto) {
		try {
			reviewService.insertReview(reviewdto);
			ReviewCartEndview.meesegePrint("삭제되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
