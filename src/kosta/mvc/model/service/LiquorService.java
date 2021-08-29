package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.LiquorDAO;
import kosta.mvc.model.dao.LiquorDAOImpl;
import kosta.mvc.model.dto.Liquor;

public class LiquorService {
	LiquorDAO liquorDao = new LiquorDAOImpl();
	
	/**
	 * ���ݴ뺰 �˻� 
	 * */
	public List<Liquor> liquorsSelectByLiquorPrice(int price) throws NotFoundException, SQLException{
		List<Liquor> list = liquorDao.liquorsSelectByLiquorPrice(price);
		if(list.size()==0)throw new NotFoundException("�ش� ���ݴ뿡 �ش��ϴ� ��ǰ�� �����.");
		return list;
	}
	
	/**
	 * ������ �˻� 
	 * */
	public List<Liquor> liquorsSelectByLiquorType(int liqourTableNo) throws NotFoundException, SQLException{
		List<Liquor> list = liquorDao.liquorsSelectByLiquorType(liqourTableNo);
		if(list.size()==0)throw new NotFoundException("�ش� ������ �ش��ϴ� ��ǰ�� �����.");
		return list;
	}
	
	/**
	 * ��ȣ(PK)�� �ش��ϴ� ���� �˻�
	 * */
	public Liquor liquorSelectByLiquorNo(int liquorNo) throws SQLException{
		Liquor liquor = liquorDao.liquorSelectByLiquorNo(liquorNo);
		if(liquor==null)throw new SQLException(liquorNo + "���� �ش��ϴ� ��ǰ�� �����.");
		return liquor;
	}
		
	/**
	 * ���� ����ϱ� 
	 * */
	public int insertLiquor(Liquor liquorDTO) throws SQLException{
		int result = liquorDao.insertLiquor(liquorDTO);
		if(result == 0) throw new SQLException("��Ͽ� �����߾��.");
		return result;
	}
	
	
	/**
	 * ���� �����ϱ� 
	 * */
	public int updateLiquor(Liquor liquorDTO) throws SQLException{
		int result = liquorDao.updateLiquor(liquorDTO);
		if(result == 0) throw new SQLException("������ �����߾��.");
		return result;
	}
		
	/**
	 * ���� �����ϱ� 
	 * */
	public int deleteLiquor(int liquorNo) throws SQLException{
		int result = liquorDao.deleteLiquor(liquorNo);
		if(result == 0) throw new SQLException("������ �����߾��.");
		return result;
	}
	
}