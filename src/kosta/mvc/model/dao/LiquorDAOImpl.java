package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Liquor;

public class LiquorDAOImpl implements LiquorDAO {

	@Override
	public List<Liquor> goodsSelectByGoodsCost(int cost) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liquor> goodsSelectByGoodsKind(String liqourType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liquor goodsSelectByGoodsName(String liqourName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGoods(Liquor liquorDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGoods(Liquor liquorDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGoods(int liquorNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
