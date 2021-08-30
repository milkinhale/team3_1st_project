package kosta.mvc.view;

import java.sql.SQLException;
import java.util.List;

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
public static void printupdateCustomerEmail(String customerEmail) {
	System.out.print("----------***** �̸��� �� " + customerEmail +" ���� �Ϸ�*****----------");
}


/**
 * ȸ����������(���)
 **/

public static void printupdateCustomerPwd(String customerPwd) {
	System.out.print("----------***** ��й�ȣ �� " + customerPwd + "�����Ϸ�*****----------" );
}


/**
 * ȸ����������(�ּ�)
 **/
public static void printupdateCustomerAddr(String customerAddr) {
	System.out.print("----------***** �ּ� �� " + customerAddr + "�����Ϸ�*****----------" );
}


/**
 * ȸ��Ż��
 **/
public static void printdeleteCustomer(String customerId) {
	System.out.print("----------***** Ż��Ǿ����ϴ� *****----------");
	}

////////////////////////////

/**
 *  ������ - ��üȸ�� ����Ʈ ���� 
 **/
public static void printselectCustomerListAll(List<Customer> customerList) {
	System.out.println("----------*****��ü ȸ�� ��� �� " + customerList );
	for(Customer customer : customerList ) {
		System.out.println(customer);
		//System.out.println(customer.getSignDate());
	}
	System.out.println();
	
	}
}


