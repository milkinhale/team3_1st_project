package kosta.mvc.view;


import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * ù ȭ��
	 * */
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			System.out.println("=== KOSTA liqour Shopping Mall ===");
			System.out.println("1.ȸ������   |   2.�α���   |   3.���̵� ã��   |   4.��й�ȣ ã��   |  0.����");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			//ȸ������
			case 1 :
				register(); 
				break;
			//�α���
			case 2 :
				login();
				break;
				
			//���̵� ã�� 
			case 3 :
				findId();
				break;
				
			//��й�ȣ ã�� 
			case 4 :
				findPwd();
				break;
			
			//�����ϱ�
			case 0 : 
				System.exit(0);
			
			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	
	/**
	 * 1. ȸ������
	 * */
	public static void register() {
		System.out.print("���̵� : ");
		 String customerId = sc.nextLine();
		 
		 System.out.print("��й�ȣ : ");
		 String pwd = sc.nextLine();
		 
		 System.out.print("�̸� : ");
		 String customerName = sc.nextLine();
		 
		 System.out.print("����(�⵵/��/��) :   ����) 2000/08/09");
		 String birth = sc.nextLine();
		 
		 System.out.print("�̸��� : ");
		 String email = sc.nextLine();
		 
		 System.out.print("�ּ� : ");
		 String addr = sc.nextLine();
		 
		 System.out.print("����ó : ");
		 String contact = sc.nextLine();
		 
		 CustomerController.register(new Customer(customerId, pwd, customerName, birth, email, addr, contact, addr, contact));
	}
	
	
	/**
	 * 2. �α���
	 * */
	public static void login() {
		 System.out.print("���̵� : ");
		 String customerId = sc.nextLine();
		 
		 System.out.print("��� : ");
		 String customerPwd = sc.nextLine();
		 
		 CustomerController.login(customerId, customerPwd); 
	}
	
	
	/**
	 * 3. ���̵� ã��
	 * */
	public static void findId() {
		System.out.print("�̸��� : ");
		String email = sc.nextLine();
		
		System.out.println("ã�� ���̵�� ������ ���ƿ�: "+ CustomerController.findCustomerId(email));
		//CustomerController.findCustomerId(email);
	}
	
	
	/**
	 * 4. ��й�ȣ ã��
	 * */
	public static void findPwd() {
		System.out.print("���̵�: ");
		String customerId = sc.nextLine();
		
		System.out.println("�̸���: ");
		String email = sc.nextLine();
		
		System.out.println("ã�� ��й�ȣ�� ������ ���ƿ�: " + CustomerController.findcustomerPwd(customerId, email));
	}
}



