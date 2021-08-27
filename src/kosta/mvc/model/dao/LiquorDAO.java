package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Liquor;

public interface LiquorDAO {
	/*
		��ü�˻� 
		List<Liquor> goodsSelect() throws SQLException;
	*/
	
	
	/**
	 * ���ݴ뺰 �˻� 
	 * */
	List<Liquor> goodsSelectByGoodsCost(int cost) throws SQLException;
	
	/**
	 * ������ �˻� 
	 * */
	List<Liquor> goodsSelectByGoodsKind(String liqourType) throws SQLException;
	
	/**
	 * �̸��� �ش��ϴ� ���� �˻�
	 * */
	Liquor goodsSelectByGoodsName(String liqourName) throws SQLException;
		
		
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
