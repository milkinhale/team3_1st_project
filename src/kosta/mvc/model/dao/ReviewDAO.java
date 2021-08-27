package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {
	/**
	 * 전체 리뷰 조회
	 * */
	List<Review> reviewSelectAll() throws SQLException;
	
	/**
	 * 회원별 리뷰 조회
	 *  판매자용 메뉴에서 사용할 것임
	 * */
	List<Review> reviewSelectByCustomerId(String customerId) throws SQLException;
	
	/**
	 * 양주종류별(양주번호별) 리뷰 조회
	 *  판매자용 메뉴에서 사용할 것임
	 * */
	List<Review> reviewSelectByLiquorNo(String liqourtype) throws SQLException;
	
	/**
	 * 리뷰 등록하기
	 * */
	int insertReview(Review review) throws SQLException;
	
	
	/**
	 * 리뷰 수정하기 -> 리뷰 번호를 받아서?
	 * 받은 리뷰번호에 해당하는 리뷰 수정?
	 *  판매자 메뉴에서 사용
	 * */
	int updateReview(Review review) throws SQLException;
	
	/**
	 * 리뷰 삭제하기  -> 리뷰 번호를 받아서
	 * 해당 리뷰번호에 해당하는 리뷰 삭제
	 * */
	int deleteReview(Review review) throws SQLException;
	
	
}
