package kosta.mvc.model.dto;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO {
	/**
	 * ȸ���� ��ٱ��� ��ȸ
	 *  �����ڿ� �޴����� ���
	 * */
	List<Cart> cartSelectByCustomerId(int customerId) throws SQLException;
	
	/**
	 * ��ٱ��� ���
	 * */
	int insertCart(Cart cart) throws SQLException;
	
	/**
	 * ��ٱ��� ����
	 * */
	int deleteCart(Cart cart) throws SQLException;

}
