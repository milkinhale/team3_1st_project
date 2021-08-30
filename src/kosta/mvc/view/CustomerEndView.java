package kosta.mvc.view;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.service.CustomerService;

/**
*로그인 
**/
public class CustomerEndView {
	public static void printMessage(String message) {
		System.out.println(message);
		}
	
	public static void printcustomerlogin(String customerId, String customerPwd) {
		System.out.print("---------*****회원 로그인 완료*****-----------");
	}
	
	
/**
 * 회원가입 
 **/
public static void printregister(Customer customer) {
	System.out.print("-----------*****회원가입완료*****------------");
}
	

/**
 * 회원가입(아이디 중복)
 **/
public static void printcustomerDupicationCheck(boolean customerId) {
	System.out.print("-----------*****아이디 사용 가능*****------------");
}

/**
 * 회원정보찾기(아이디)
 **/
public static void printfindCustomerId(String customerId) {
	System.out.print("******아이디  ▶ " + customerId + "입니다.*****" );
	
}

/**
 * 회원정보찾기(비밀번호)
 **/
public static void printfindCustomerPwd(String customerPwd) {
	System.out.println("*****비밀번호 ▶" +customerPwd + "입니다.*****");

}

/**
 * 회원정보수정(이메일)
 **/
public static void printupdateCustomerEmail(String customerEmail) {
	System.out.print("----------***** 이메일 ▶ " + customerEmail +" 수정 완료*****----------");
}


/**
 * 회원정보수정(비번)
 **/

public static void printupdateCustomerPwd(String customerPwd) {
	System.out.print("----------***** 비밀번호 ▶ " + customerPwd + "수정완료*****----------" );
}


/**
 * 회원정보수정(주소)
 **/
public static void printupdateCustomerAddr(String customerAddr) {
	System.out.print("----------***** 주소 ▶ " + customerAddr + "수정완료*****----------" );
}


/**
 * 회원탈퇴
 **/
public static void printdeleteCustomer(String customerId) {
	System.out.print("----------***** 탈퇴되었습니다 *****----------");
	}

////////////////////////////

/**
 *  관리자 - 전체회원 리스트 보기 
 **/
public static void printselectCustomerListAll(List<Customer> customerList) {
	System.out.println("----------*****전체 회원 목록 ▶ " + customerList );
	for(Customer customer : customerList ) {
		System.out.println(customer);
		//System.out.println(customer.getSignDate());
	}
	System.out.println();
	
	}
}


