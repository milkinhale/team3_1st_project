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

/**
 * ȸ�� ���� ����
 * (�� ȸ����) ����������-ȸ������ �������� ����� ����.
 * */
public static void printCustomer(Customer customer) {
	//ȸ�� �̸�, ����, �̸���, �ּ�, ����ó, �����ϸ� �����ݴϴ�.
	String customerName = customer.getCustomerName();
	String birth = customer.getBirth();
	String email = customer.getEmail();
	String addr = customer.getAddr();
	String contact = customer.getContact();
	String signDate = customer.getSignDate();
	
	System.out.println("����: " + customerName + " | ����: " + birth + " | �̸���: " + email + " | �ּ�: " + addr + " | ����ó : " + contact + " | ������: " + signDate);
	System.out.println();
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


