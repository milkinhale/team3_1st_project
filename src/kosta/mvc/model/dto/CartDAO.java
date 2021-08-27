package kosta.mvc.model.dto;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO {
	/**
	 * 회원별 장바구니 조회
	 *  구매자용 메뉴에서 사용
	 * */
	List<Cart> cartSelectByCustomerId(int customerId) throws SQLException;
	
	/**
	 * 장바구니 담기
	 * */
	int insertCart(Cart cart) throws SQLException;
	
	/**
	 * 장바구니 비우기
	 * */
	int deleteCart(Cart cart) throws SQLException;

}
