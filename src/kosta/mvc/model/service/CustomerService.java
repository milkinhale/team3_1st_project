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
	public Customer customerLogin(String customerId, String customerPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.customerLogin(customerId, customerPwd);
		if(customer==null) {
			throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.");
		}
		
		String seller = customer.getSeller();
		
		//�α��� �� ���� �����ϱ�
		Session session = new Session(customerId, seller);
		
		
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
		
		
		//ȸ�� ���̵� �ߺ� �� �ְ� 
		public boolean customerIdDuplicationCheck(String customerId) throws SQLException {
			String id = customerDao.customerIdDuplicationCheck(customerId);
			if(id == customerId) {
				return false;
			}else {
				return true;
			}
		}
		


/**
 * ȸ������ã�� (���̵�)
 **/
	public String findCustomerId(String email) throws NotFoundException, SQLException {
		String id  =customerDao.findCustomerId(email);
		if(id == null) throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.");
			return id;			
	}
	
/**
 * ȸ������ã�� (���)
 **/
	public String findCustomerPwd(String customerId, String email ) throws NotFoundException, SQLException {
		String pwd = customerDao.findCustomerPwd(customerId, email); 
		if(pwd == null) throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.");
		return pwd;
		
	}

/**
 * ȸ���������� (�̸���) -update	
 **/
	public int updateCustomerEmail(String customerId, String email ) throws SQLException {
		int result = customerDao.updateCustomerEmail(customerId, email); 
		if(result == 0) throw new SQLException("������ �ٽ� Ȯ�����ּ���.");
		return result;
		
	}
	
/**	
 * ȸ���������� (���)-update
 **/
	public int updateCustomerPwd(String customerId, String email ) throws SQLException {
		int result = customerDao.updateCustomerPwd(customerId, email); 
		if(result == 0) throw new SQLException("������ �ٽ� Ȯ�����ּ���.");
		return result;
		
	}
	
	
/**
 * ȸ���������� (�ּ�)-update
 **/
	
	public int updateCustomerAddr(String customerId, String Addr ) throws SQLException {
		int result = customerDao.updateCustomerAddr(customerId, Addr); 
		if(result == 0) throw new SQLException("������ �ٽ� Ȯ�����ּ���.");
		return result;
		
	}
/**
 * ȸ�� Ż�� - delete
 **/
	public int deleteCustomer(String customerId) throws SQLException{
		int result = customerDao.deleteCustomer(customerId);
		if(result == 0) throw new SQLException("������ �ٽ� Ȯ�����ּ���");
		return result;
	}
	
	
}
