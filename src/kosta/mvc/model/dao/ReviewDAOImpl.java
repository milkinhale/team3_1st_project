package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public List<Review> reviewSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> reviewSelectByCustomerId(String customerId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> reviewSelectByLiquorNo(String liqourtype) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReview(Review review) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReview(Review review) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReview(Review review) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
