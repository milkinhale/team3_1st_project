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
	public static void login(String userId, String userPwd) {
		try {
			Customer customer = customerService.login(userId, userPwd);
			MenuView.printUserMenu(userId);
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
}
