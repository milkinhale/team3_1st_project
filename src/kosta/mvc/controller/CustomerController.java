package kosta.mvc.controller;

import java.sql.SQLException;

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
			MenuView.menu();
		}catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
    }
    
    
    /**
     * 회원정보찾기 (아이디) 
     **/
    public static void findCustomerId(String customerId) {
    	try {
    		String id = customerService.findCustomerId(customerId);
    		MenuView.printSubMenu();
    		MenuView.menu();
    		
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
    		MenuView.printSubMenu();
    		MenuView.menu();
    	
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
    		MenuView.printSubMenu(); 
    		MenuView.menu();
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}   
    }


    /**
     * 회원정보수정 (비번) 
     **/
    public static void updateCustomerPwd(String customerId, String email) {
    	try {
    		int result = customerService.updateCustomerPwd(customerId, email);    
    		MenuView.printSubMenu();
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
    		MenuView.printSubMenu();
    		MenuView.menu();
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
    		MenuView.printSubMenu();
    		MenuView.menu();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    		
    	}
    }
    
    /**
	 * 회원인지 판매자 확인  
	 **/
	public static void sellerCheck (String customerId) throws SQLException{
		try {
			String seller = customerService.sellerCheck(customerId);
			if(seller.equals("SELLER")) {
				MenuView.printAdminMenu();
			}else {
				MenuView.printUserMenu(customerId);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
