package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import kosta.mvc.model.dto.Review;
import util.DBUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();
	static Scanner sc =new Scanner(System.in);
	
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
	 *  ����ȣ(���̵�)�� �ش��ϴ� ���� �˻�
	 * */
	
	@Override
	public List<Review> reviewSelectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Review> reivewList = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByCustomerId"); //�̰��� �ܺ� Ű������ �����Ѵ�
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?�� �ִٸ� set �ʿ� 
			
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
	 * ���������� ���� �˻�
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
			//?�� �ִٸ� set �ʿ� 
			
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
	 * ���� ���
	 * */
	@Override
	public int insertReview(Review reviewdto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.insertReview");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?��
			ps.setInt(1, reviewdto.getLiquorNo());
			ps.setString(2, reviewdto.getCustomerId());
			ps.setString(3, reviewdto.getContent());
			
			result = ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * ���� �����ϱ�
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
			//?��
			ps.setString(1, review.getContent());
			ps.setInt(2, review.getReviewNo());

			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	
	/**
	 * ���� �����ϱ�
	 * */
	@Override
	public int deleteReview(int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result = 0;
		String sql = proFile.getProperty("review.deleteReview");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?��
			ps.setInt(1, reviewNo);

			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

}
