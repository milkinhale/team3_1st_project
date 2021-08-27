package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Liquor;

public interface LiquorDAO {
	/*
		전체검색 
		List<Liquor> goodsSelect() throws SQLException;
	*/
	
	/**
	 * 가격대별 검색 
	 * */
	List<Liquor> liquorsSelectByLiquorPrice(int cost) throws SQLException;
	
	/**
	 * 종류별 검색 
	 * */
	List<Liquor> liquorsSelectByLiquorType(String liqourType) throws SQLException;
	
	
	/**
	 * 번호(PK)에 해당하는 정보 검색
	 * */
	Liquor liquorSelectByLiquorNo(int liquorNo) throws SQLException;
		
		
	/**
	 * 양주 등록하기 
	 * */
	int insertLiquor(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * 양주 수정하기 
	 * */
	int updateLiquor(Liquor liquorDTO) throws SQLException;
	
	/**
	 * 재고 수량 바꾸기 
	 * */
	int updateStock(int count, int liquorNo) throws SQLException;
		
	/**
	 * 양주 삭제하기 
	 * */
	int deleteLiquor(int liquorNo) throws SQLException;
}
