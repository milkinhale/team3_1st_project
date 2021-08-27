package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Liquor;

public interface GoodsDAO {
	/*
		��ü�˻� 
		List<Liquor> goodsSelect() throws SQLException;
	*/
	
	
	/**
	 * ���ݴ뺰 �˻� 
	 * */
	List<Liquor> goodsSelectByGoodsCost() throws SQLException;
	
	/**
	 * ������ �˻� 
	 * */
	List<Liquor> goodsSelectByGoodsKind() throws SQLException;
	
	/**
	 * �̸��� �ش��ϴ� ���� �˻�
	 * */
	Liquor goodsSelectByGoodsName(String goodsName) throws SQLException;
		
		
	/**
	 * ���� ����ϱ� 
	 * */
	int insertGoods(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * ���� �����ϱ� 
	 * */
	int updateGoods(Liquor liquorDTO) throws SQLException;
		
		
	/**
	 * ���� �����ϱ� 
	 * */
	int deleteGoods(int liquorNo) throws SQLException;
}
