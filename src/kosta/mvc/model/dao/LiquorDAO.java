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
	List<Liquor> goodsSelectByGoodsPrice(int cost) throws SQLException;
	
	/**
	 * 종류별 검색 
	 * */
	List<Liquor> goodsSelectByGoodsKind(String liqourType) throws SQLException;
	
	/**
	 * 이름에 해당하는 정보 검색
	 * */
	Liquor goodsSelectByGoodsName(String liqourName) throws SQLException;
		
		
	/**
	 * 양주 등록하기 
	 * */
	int insertGoods(Liquor liquorDTO) throws SQLException;
	
		
	/**
	 * 양주 수정하기 
	 * */
	int updateGoods(Liquor liquorDTO) throws SQLException;
		
		
	/**
	 * 양주 삭제하기 
	 * */
	int deleteGoods(int liquorNo) throws SQLException;
}
