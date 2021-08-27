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
	List<Liquor> liquorsSelectByLiquorPrice(int cost) throws SQLException;
	
	/**
	 * ������ �˻� 
	 * */
	List<Liquor> liquorsSelectByLiquorType(String liqourType) throws SQLException;
	
	
	/**
	 * ��ȣ(PK)�� �ش��ϴ� ���� �˻�
	 * */
	Liquor liquorSelectByLiquorNo(int liquorNo) throws SQLException;
		
		
	/**
	 * ���� ����ϱ� 
	 * */
	int insertLiquor(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * ���� �����ϱ� 
	 * */
	int updateLiquor(Liquor liquorDTO) throws SQLException;
	
	/**
	 * ��� ���� �ٲٱ� 
	 * */
	int updateStock(int count, int liquorNo) throws SQLException;
		
	/**
	 * ���� �����ϱ� 
	 * */
	int deleteLiquor(int liquorNo) throws SQLException;
}
