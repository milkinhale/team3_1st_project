package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Liquor;

public class GoodsDAOImpl implements GoodsDAO {

	@Override
	public List<Liquor> goodsSelectByGoodsCost() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liquor> goodsSelectByGoodsKind() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liquor goodsSelectByGoodsName(String goodsName) throws SQLException {
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
