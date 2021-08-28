package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Cart;

public interface CartDAO {
	/**
	 * ȸ���� ��ٱ��� ��ȸ
	 *  �����ڿ� �޴����� ���
	 * */
	List<Cart> cartSelectByCustomerId(String customerId) throws SQLException;
	
	/**
	 * ��ٱ��� ���
	 * */
	int insertCart(Cart cart) throws SQLException;
	
	/**
	 * ��ٱ��� ����
	 * */
	int deleteCart(Cart cart) throws SQLException;

}
