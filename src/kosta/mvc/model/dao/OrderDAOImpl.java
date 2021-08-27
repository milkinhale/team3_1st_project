package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Orders;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Orders> orderSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> orderSelectByCustomerNo(String customerId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
