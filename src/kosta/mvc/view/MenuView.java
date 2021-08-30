package kosta.mvc.view;


import java.util.Scanner;

import kosta.mvc.controller.CartController;
import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * ù ȭ�� ���
	 * */
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			System.out.println("=== KOSTA liqour Shopping Mall ===");
			System.out.println("1. ȸ������   |   2. �α���   |   3. ���̵� ã��   |   4. ��й�ȣ ã��   |  9. ����");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			//����ϱ�
			case 1 :
				MenuView.register(); 
				break;
			//�α���
			case 2 :
				MenuView.login();
				break;
				
			//���̵� ã�� 
			case 3 :
				
				break;
				
			//��й�ȣ ã�� 
			case 4 :
				
				break;
			
			//�����ϱ�
			case 9 : 
				System.exit(0);
			}
		}
	}
	
	
	/**
	 * ���� �α��� �� ��� 
	 * */
	public static void printUserMenu(String customerId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +customerId+ " �α��� �� -----");
			System.out.println("1.ī�װ��� ��ǰ����  |  2.���ݴ뺰 ��ǰ�˻�  |  3.��ǰ�� �˻�  | 4.�ֹ��ϱ�  |  5.��ٱ��� ���  |  6.��ٱ��� ����  |  7.���� �˻�  |  8.���������� |  9.�α׾ƿ�");
			int menu =Integer.parseInt( sc.nextLine());
			
			/*
			switch(menu) {
				//ī�װ� ��ǰ���� 
				case 1 :
					logout(userId);// 
					return;
					//break;
				
				//���ݴ뺰 �˻� 
				case 2 :
					GoodsController.goodsSelect();//��ü ��ǰ��ȸ
					break;
				
				//��ǰ�� �˻� 
				 case 3 :
					printInputOrder(userId);
					break;
					
				//�ֹ��ϱ�
				case 4 :
					printInputOrder(userId);
					break;
				
				//��ٱ��� ���
				case 5 :
					OrderController.selectOrdersByUserId(userId);
					break;
				
				//��ٱ��� ����  
				case 6 :
					MenuView.putCart(userId);// 
					break;	
				
				//���� �˻� 
				case 7 : 
					viewCart(userId);
					break;
				
				//���������� 
				case 8 : 
					viewCart(userId);
					break;
					
				//�α׾ƿ� (�ٽ� �޴���)
				case 9 : 
					MenuView.menu();
					break;
				}*/
		}
		
	}
	
	
	public static void printSubMenu() {
		System.out.println("1. ����   |  2.Ż��   | 9. ������");  
		
		//�̸��� ���� 
		System.out.print("���̵�: ");
		String customerId = sc.nextLine();
		System.out.print("�̸���");
		String customerEmail = sc.nextLine();
		
		System.out.print("������ �̸��� �Է�: ");
		String customerEmail = sc.nextLine();
		
		// �ּ� ���� 
		
		//��й�ȣ ���� 
		
		//ȸ��Ż��
		System.out.print("���̵�");
		String customerId = sc.nextLine();
		
		
	}
	
	public static void printAdminMenu() {
		System.out.println("-- ������ �޴� --");
		System.out.println("1. ID�� �˻�   |  2.�̸����� �˻�  | 3.��ü �˻�  |  9. ������");
		
	}
	
	/**
	 * ȸ������
	 * */
	public static void register() {
		System.out.print("���̵� : ");
		 String cutomerId = sc.nextLine();
		 
		 System.out.print("��� : ");
		 String Pwd = sc.nextLine();
		 
		 System.out.print("�̸� : ");
		 String cutomerName = sc.nextLine();
		 
		 System.out.print("���� : ");
		 String birth = sc.nextLine();
		 
		 System.out.print("�̸��� : ");
		 String email = sc.nextLine();
		 
		 System.out.print("�ּ� : ");
		 String addr = sc.nextLine();
		 
		 System.out.print("����ó : ");
		 String contact = sc.nextLine();
		 
		 Customer customer = new Customer(cutomerId, Pwd, cutomerName, birth, email, addr, contact, addr, contact);
		 CustomerController.register(customer);
	}
	
	/**
	 * �α��� �޴�
	 * */
	public static void login() {
		 System.out.print("���̵� : ");
		 String customerId = sc.nextLine();
		 
		 System.out.print("��� : ");
		 String customerPwd = sc.nextLine();
		 
		 CustomerController.login(customerId, customerPwd); 
	}
	
	/**
	 * �α׾ƿ�
	 * */
	public static void logout(String customerId) {
		Session session = new Session(customerId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
	}
	
	/**
	 * �ֹ��ϱ�
	 * */
    public static void printInputOrder(String userId) {
    	System.out.print("�ֹ���ǰ��ȣ : ");
		 String goodsId = sc.nextLine();
		 
		 System.out.print("�ֹ����� : ");
		 int qty = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("����ּ� : ");
		 String address = sc.nextLine();
		 
			 
		 /*Orders orders = new Orders(0, null, userId, address, 0);
		 OrderLine orderLine = new OrderLine(0, 0, goodsId, 0, qty, 0);
		 
		 orders.getOrderLineList().add(orderLine);
		 
		 OrderController.insertOrders(orders);*/	 
    }
    
    /**
     * ��ٱ��� ���
     * */
    public static void putCart(String id) {
		System.out.println("--��ٱ��� ��� �۾� --");
		System.out.print("��ǰ��ȣ : ");
		String goodsId = sc.nextLine();
		System.out.print("���� : ");
		int qty = Integer.parseInt(sc.nextLine());
		
		CartController.putCart(id,goodsId,qty);
	
		
	}
	
    /**
     * ��ٱ��� ����
     * */
	public static void viewCart(String id) {
		//CartController.viewCart(id);
		
		
		
	}
}



