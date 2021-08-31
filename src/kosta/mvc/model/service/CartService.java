package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.CartDAO;
import kosta.mvc.model.dao.CartDAOImpl;
import kosta.mvc.model.dto.Cart;

public class CartService {
	private CartDAO cartDAO = new CartDAOImpl();
	/**
	 * ȸ�� ���̵𺰷� ��ٱ��� ��ȸ�ϱ�
	 * */
	public List<Cart> cartSelectByCustomerId(String customerId) throws SQLException {
		List<Cart> cartList = cartDAO.cartSelectByCustomerId(customerId);
		if(cartList == null || cartList.isEmpty()) {
			throw new SQLException(customerId + "�� ��ٱ��ϰ� ����ֽ��ϴ�.");
		}
		
		return cartList;
	}
	
	/**
	 * ��ٱ��� ���
	 * */
	public void insertCart(String customerId, int liquorNo, int cartCount) throws SQLException {
		int result = cartDAO.insertCart(customerId, liquorNo, cartCount);
		if(result == 0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");

	}
	
	/**
	 * ��ٱ��� �����ϱ�
	 * */
	public void deleteCart(String customerId) throws SQLException {
		int result = cartDAO.deleteCart(customerId);
		if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�.");

	}
}
