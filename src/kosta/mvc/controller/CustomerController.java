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
  * �α���
  * */
	public static void main(String[] args) {
		//login("��", "1234");
		//findCustomerId("DDD444@naver.com");
	}
	
	public static void login(String customerId, String customerPwd) {
		try {
			Customer customer = customerService.customerLogin(customerId, customerPwd);
			sellerCheck(customerId);
		}catch (Exception e) {
			FailView.errorMessage("�α��ο� �����߾��.");
		}
	}
	
	/**
	 * ȸ������
	 * */
    public static void register(Customer customer) {
    	try {
			customerService.register(customer);
			EndView.printMessage("ȸ�����Կ� �����߾��.");
		}catch (Exception e) {
			FailView.errorMessage("ȸ�����Կ� �����߾��.");
		}
    }
    
    
    /**
     * ȸ������ã�� (���̵�) 
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
     * ȸ������ã�� (���) 
     **/
    public static void findcustomerPwd(String customerId, String email) {
    	try {
    		String pwd = customerService.findCustomerPwd(customerId, email);
    		
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }

    /**										 
     * ȸ����������(�̸���) 
     **/
    public static void updateCustomerEmail(String customerId, String email) {
    	try {
    		int result = customerService.updateCustomerEmail(customerId,email);
    		EndView.printMessage("�̸����� �����Ǿ����.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}   
    }


    /**
     * ȸ���������� (���) 
     **/
    public static void updateCustomerPwd(String customerId, String pwd) {
    	try {
    		int result = customerService.updateCustomerPwd(customerId, pwd);    
    		EndView.printMessage("��й�ȣ�� �����Ǿ����.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    
    /**
     * ȸ����������(�ּ�)
     **/
    public static void updateCustomerAddr(String customerId, String Addr) {
    	try {
    		int result = customerService.updateCustomerAddr(customerId, Addr);
    		EndView.printMessage("�ּҰ� �����Ǿ����.");
    	}catch(Exception e) {
    		e.printStackTrace();
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    
    

    /**
     * ȸ��Ż��
     **/
    
    public static void deleteCustomer(String customerId) {
    	try {
    		int id = customerService.deleteCustomer(customerId);
    		EndView.printMessage("Ż��Ǿ����. ������ �� ������!");
    	}catch(Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    /**
	 * ȸ������ �Ǹ��� Ȯ��  
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
