package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.service.CustomerService;
import kosta.mvc.view.AdminMenuView;
import kosta.mvc.view.CustomerMenuView;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.LiquorEndView;
import kosta.mvc.view.MenuView;

public class CustomerController {
	static CustomerService customerService = new CustomerService();
 /**
  * 로그인
  * */
	public static void main(String[] args) {
		//login("깃", "1234");
		//findCustomerId("DDD444@naver.com");
	}
	
	public static void login(String customerId, String customerPwd) {
		try {
			Customer customer = customerService.customerLogin(customerId, customerPwd);
			sellerCheck(customerId);
		}catch (Exception e) {
			FailView.errorMessage("로그인에 실패했어요.");
		}
	}
	
	/**
	 * 회원가입
	 * */
    public static void register(Customer customer) {
    	try {
			customerService.register(customer);
			EndView.printMessage("회원가입에 성공했어요.");
		}catch (Exception e) {
			FailView.errorMessage("회원가입에 실패했어요.");
		}
    }
    
    
    /**
     * 회원정보찾기 (아이디) 
     **/
    public static void findCustomerId(String customerEmail) {
    	try {
    		customerService.findCustomerId(customerEmail);
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}	
    }


    /**
     * 회원정보찾기 (비번) 
     **/
    public static void findcustomerPwd(String customerId, String email) {
    	try {
    		String pwd = customerService.findCustomerPwd(customerId, email);
    		
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }

    /**										 
     * 회원정보수정(이메일) 
     **/
    public static void updateCustomerEmail(String customerId, String email) {
    	try {
    		int result = customerService.updateCustomerEmail(customerId,email);
    		EndView.printMessage("이메일이 수정되었어요.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}   
    }


    /**
     * 회원정보수정 (비번) 
     **/
    public static void updateCustomerPwd(String customerId, String pwd) {
    	try {
    		int result = customerService.updateCustomerPwd(customerId, pwd);    
    		EndView.printMessage("비밀번호가 수정되었어요.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    
    /**
     * 회원정보수정(주소)
     **/
    public static void updateCustomerAddr(String customerId, String Addr) {
    	try {
    		int result = customerService.updateCustomerAddr(customerId, Addr);
    		EndView.printMessage("주소가 수정되었어요.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    
    

    /**
     * 회원탈퇴
     **/
    
    public static void deleteCustomer(String customerId) {
    	try {
    		int id = customerService.deleteCustomer(customerId);
    		EndView.printMessage("탈퇴되었어요. 다음에 또 만나요!");
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    /**
	 * 회원인지 판매자 확인  
	 **/
	public static void sellerCheck (String customerId){
		try {
			String seller = customerService.sellerCheck(customerId);
			if(seller.equals("SELLER")) {
				AdminMenuView.sellerMenu(customerId);
			}else {
				CustomerMenuView.customerMenu(customerId);
			}
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectCustomerListAll(){
		try {
			List<Customer> customerList = customerService.selectCustomerListAll();
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
