package kosta.mvc.model.service;

import java.sql.SQLException;
import java.time.LocalDate;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CouponDAO;
import kosta.mvc.model.dao.CouponDAOImpl;
import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	CouponDAO coupon = new CouponDAOImpl();
	
	
  /**
   * �α���
   * */
	public Customer login(String userId, String userPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.customerLogin(userId, userPwd);
		if(customer==null) {
			throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.");
		}
		
		String seller = customer.getSeller();
		
		//�α��� �� ���� �����ϱ�
		Session session = new Session(userId, seller);
		
		
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);
		
		return customer;
	}

	/**
	 * ȸ������
	 * */
	public void register(Customer customer) throws SQLException{
		LocalDate now = LocalDate.now();
		String [] birth = customer.getBirth().split("/");
		int age = now.getYear() - Integer.parseInt(birth[0]);
		if(Integer.parseInt(birth[1]) > now.getMonthValue()) {
			age--;
		} else if(Integer.parseInt(birth[2]) >= now.getDayOfMonth()) {
			age--;
		}
		if(age >= 19) {
		    int result =  customerDao.insertCustomer(customer);
		    if(result==0)throw new SQLException("ȸ�����Կ� �����Ͽ����ϴ�.");
		    coupon.insertCouponTable(customer.getCustomerId(), 15);
		} else {
			throw new SQLException("�ֵ��� ����");
		}
		
	}

/**
 * ȸ���������� (�̸���)
 **/
	
	
}
