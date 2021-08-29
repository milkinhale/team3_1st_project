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
   * 로그인
   * */
	public Customer customerLogin(String customerId, String customerPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.customerLogin(customerId, customerPwd);
		if(customer==null) {
			throw new NotFoundException("정보를 다시 확인해주세요.");
		}
		
		String seller = customer.getSeller();
		
		//로그인 된 정보 저장하기
		Session session = new Session(customerId, seller);
		
		
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);
		
		return customer;
	}

	/**
	 * 회원가입
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
		    if(result==0)throw new SQLException("회원가입에 실패하였습니다.");
		    coupon.insertCouponTable(customer.getCustomerId(), 15);
		} else {
			throw new SQLException("애들은 가라");
		}
	}	
		
		
		//회원 아이디가 중복 못 넣게 
		public boolean customerIdDuplicationCheck(String customerId) throws SQLException {
			String id = customerDao.customerIdDuplicationCheck(customerId);
			if(id == customerId) {
				return false;
			}else {
				return true;
			}
		}
		


/**
 * 회원정보찾기 (아이디)
 **/
	public String findCustomerId(String email) throws NotFoundException, SQLException {
		String id  =customerDao.findCustomerId(email);
		if(id == null) throw new NotFoundException("정보를 다시 확인해주세요.");
			return id;			
	}
	
/**
 * 회원정보찾기 (비번)
 **/
	public String findCustomerPwd(String customerId, String email ) throws NotFoundException, SQLException {
		String pwd = customerDao.findCustomerPwd(customerId, email); 
		if(pwd == null) throw new NotFoundException("정보를 다시 확인해주세요.");
		return pwd;
		
	}

/**
 * 회원정보수정 (이메일) -update	
 **/
	public int updateCustomerEmail(String customerId, String email ) throws SQLException {
		int result = customerDao.updateCustomerEmail(customerId, email); 
		if(result == 0) throw new SQLException("정보를 다시 확인해주세요.");
		return result;
		
	}
	
/**	
 * 회원정보수정 (비번)-update
 **/
	public int updateCustomerPwd(String customerId, String email ) throws SQLException {
		int result = customerDao.updateCustomerPwd(customerId, email); 
		if(result == 0) throw new SQLException("정보를 다시 확인해주세요.");
		return result;
		
	}
	
	
/**
 * 회원정보수정 (주소)-update
 **/
	
	public int updateCustomerAddr(String customerId, String Addr ) throws SQLException {
		int result = customerDao.updateCustomerAddr(customerId, Addr); 
		if(result == 0) throw new SQLException("정보를 다시 확인해주세요.");
		return result;
		
	}
/**
 * 회원 탈퇴 - delete
 **/
	public int deleteCustomer(String customerId) throws SQLException{
		int result = customerDao.deleteCustomer(customerId);
		if(result == 0) throw new SQLException("정보를 다시 확인해주세요");
		return result;
	}
	
	
}
