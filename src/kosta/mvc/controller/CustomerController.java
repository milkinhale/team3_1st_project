package kosta.mvc.controller;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.service.CustomerService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class CustomerController {
	static CustomerService customerService = new CustomerService();
 /**
  * 로그인
  * */
	public static void login(String customerId, String customerPwd) {
		try {
			Customer customer = customerService.customerLogin(customerId, customerPwd);
			MenuView.printUserMenu(customerId);
			//MenuView.menu();
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 회원가입
	 * */
    public static void register(Customer customer) {
    	try {
			customerService.register(customer);
			EndView.printMessage("회원가입에 성공하였습니다.");
			//MenuView.menu();
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
    }
    
    
    /**
     * 회원정보찾기 (아이디) 
     **/
    public static void findCustomerId(String customerId) {
    	try {
    		String id = customerService.findCustomerId(customerId);
    		MenuView.printUserMenu(customerId);
    		//MenuView.menu();
    		
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}	
    }


    /**
     * 회원정보찾기 (비번) 
     **/
    public static void findcustomerPwd(String customerId, String email) {
    	try {
    		String pwd = customerService.findCustomerPwd(customerId, email);
    		MenuView.printUserMenu(pwd);
    		//MenuView.menu();
    	
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }

    /**
     * 회원정보수정(이메일) 
     **/
    public static void updateCustomerEmail(String customerId, String eamil) {
    	try {
    		String email = customerService.updateCustomerEmail(customerId,email);
    		MenuView.printUserMenu(email);
    	}
    }


    /**
     * 회원정보수정 (비번) 
     **/
    
    /**
     * 회원정보수정(주소)
     **/

    /**
     * 회원탈퇴
     **/
}
