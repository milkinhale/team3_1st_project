package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Review;
import util.DBUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();
	
	@Override
	public List<Review> reviewSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Review> reivewList = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectAll");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Review reviewDto = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				reivewList.add(reviewDto);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		
		return reivewList;
	}

	/**
	 *  고객번호(아이디)에 해당하는 리뷰 검색
	 * */
	
	@Override
	public List<Review> reviewSelectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Review> reivewList = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByCustomerId"); //이것을 외부 키값으로 관리한다
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 set 필요 
			
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			if(rs.next()) {
				Review reviewDto = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				reivewList.add(reviewDto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reivewList;
	}

	/**
	 * 양주종류별 리뷰 검색
	 * */
	
	@Override
	public List<Review> reviewSelectByLiquorNo(int liquorNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Review> reivewList = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByLiquorNo"); 
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 set 필요 
			
			ps.setInt(1, liquorNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				Review reviewDto = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				reivewList.add(reviewDto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reivewList;
	}

	
	/**
	 * 리뷰 등록
	 * */
	@Override
	public int insertReview(Review review) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.insertReview");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setInt(1, review.getLiquorNo());
			ps.setString(2, review.getCustomerId());
			ps.setString(3, review.getContent());
			
			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 리뷰 수정하기
	 * */
	
	@Override
	public int updateReview(Review review) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("review.update");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setString(1, review.getContent());
			ps.setInt(2, review.getReviewNo());

			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	
	/**
	 * 리뷰 삭제하기
	 * */
	@Override
	public int deleteReview(Review review) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("review.deleteReview");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?값
			ps.setInt(1, review.getReviewNo());

			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

}
