package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int insertcustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer customerLogin(String customerId, String customerpwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findcustomerId(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findcusomerPwd(String customerId, String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatecustomerEmail(String customerId, String email) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatecustomerPwd(String customerId, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatecustomerAddr(String customerId, String addr) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletecustomer(String customerId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
