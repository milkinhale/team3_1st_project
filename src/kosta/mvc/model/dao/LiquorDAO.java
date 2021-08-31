package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.LiquorTable;

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
	 * ���� ī�װ�
	 * */
	List<LiquorTable> selectLiquorTable() throws SQLException;
	
	/**
	 * ������ �˻� 
	 * */
	List<Liquor> liquorsSelectByLiquorType(int liqourTableNo) throws SQLException;
	
	
	/**
	 * ��ȣ(PK)�� �ش��ϴ� ���� �˻�
	 * */
	Liquor liquorSelectByLiquorNo(int liquorNo) throws SQLException;
	
	/**
	 * ���ָ����� �˻� 
	 * */
	Liquor liquorSelectByLiquorName(String name) throws SQLException;
		
	/**
	 * ���� ����ϱ� 
	 * */
	int insertLiquor(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * ���� �����ϱ� 
	 * */
	int updateLiquor(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * ���� �����ϱ� 
	 * */
	int deleteLiquor(int liquorNo) throws SQLException;
	
	
	/**
	 * ���� ���� �����ϱ� 
	 * */
	int updateStock(Liquor liquorDTO) throws SQLException;
}
