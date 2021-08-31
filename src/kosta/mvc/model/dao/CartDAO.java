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
	//int insertCart(Cart cart) throws SQLException;
	

	/**
	 * ��ٱ��Ϲ�ȣ�� �Է��ؼ� ��ٱ��� �����ϱ� 
	 * */
	//int deleteCart(int cartNo) throws SQLException;

	/**
	 * ��ٱ��� ��ü ��ȸ�ϱ�
	 * */
	List<Cart> cartSelectAll() throws SQLException;

	/**
	 * ��ٱ��Ϲ�ȣ�� �Է��ؼ� ��ٱ��� �����ϱ� 
	 * */
	int deleteCart(String customerId) throws SQLException;

	/**
	 * ��ٱ��� ���
	 * */
	int insertCart(String customerId, int liquorNo, int cartCount) throws SQLException;

}
