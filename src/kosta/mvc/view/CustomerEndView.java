package kosta.mvc.view;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.service.CustomerService;

/**
*�α��� 
**/
public class CustomerEndView {
	public static void printMessage(String message) {
		System.out.println(message);
		}
	
	public static void printcustomerlogin(String customerId, String customerPwd) {
		System.out.print("---------*****ȸ�� �α��� �Ϸ�*****-----------");
	}
	
	
/**
 * ȸ������ 
 **/
public static void printregister(Customer customer) {
	System.out.print("-----------*****ȸ�����ԿϷ�*****------------");
}
	

/**
 * ȸ������(���̵� �ߺ�)
 **/
public static void printcustomerDupicationCheck(boolean customerId) {
	System.out.print("-----------*****���̵� ��� ����*****------------");
}

/**
 * ȸ������ã��(���̵�)
 **/
public static void printfindCustomerId(String customerId) {
	System.out.print("******���̵�  �� " + customerId + "�Դϴ�.*****" );
	
}

/**
 * ȸ������ã��(��й�ȣ)
 **/
public static void printfindCustomerPwd(String customerPwd) {
	System.out.println("*****��й�ȣ ��" +customerPwd + "�Դϴ�.*****");

}

/**
 * ȸ����������(�̸���)
 **/
public static void updateCustomerEmail(String customerEmail) {
	System.out.print("----------***** �̸��� �� " + customerEmail +" ���� �Ϸ�*****----------");
}


/**
 * ȸ����������(���)
 **/

public static void updateCustomerPwd(String customerPwd) {
	System.out.print("----------***** ��й�ȣ �� " + customerPwd + "�����Ϸ�*****----------" );
}


/**
 * ȸ����������(�ּ�)
 **/
public static void updateCustomerAddr(String customerAddr) {
	System.out.print("----------***** �ּ� �� " + customerAddr + "�����Ϸ�*****----------" );
}


/**
 * ȸ��Ż��
 **/
public static void deleteCustomer(String customerId) {
	System.out.print("----------***** Ż��Ǿ����ϴ� *****----------");
	}

/**
 * ���� 
 **/

}


