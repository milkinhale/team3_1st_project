package kosta.mvc.controller;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.service.CustomerService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class CustomerController {
	static CustomerService customerService = new CustomerService();
 /**
  * �α���
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
	 * ȸ������
	 * */
    public static void register(Customer customer) {
    	try {
			customerService.register(customer);
			EndView.printMessage("ȸ�����Կ� �����Ͽ����ϴ�.");
			//MenuView.menu();
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
    }
    
    
    /**
     * ȸ������ã�� (���̵�) 
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
     * ȸ������ã�� (���) 
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
     * ȸ����������(�̸���) 
     **/
    public static void updateCustomerEmail(String customerId, String eamil) {
    	try {
    		String email = customerService.updateCustomerEmail(customerId,email);
    		MenuView.printUserMenu(email);
    	}
    }


    /**
     * ȸ���������� (���) 
     **/
    
    /**
     * ȸ����������(�ּ�)
     **/

    /**
     * ȸ��Ż��
     **/
}
