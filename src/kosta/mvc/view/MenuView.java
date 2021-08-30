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
	
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				MenuView.register(); // ����
				break;
			case 2 :
				MenuView.login();// �α���
				break;
			case 3: 
				MenuView.
			

			case 9 : 
				System.exit(0);
			}
		}

	}
	


	public static void printMenu() {
		System.out.println("=== KOSTA liqour Shopping Mall ===");
		System.out.println("1. ����   |   2. �α���   |  9. ����");
	}
	
	
	public static void printUserMenu(String customerId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +customerId+ " �α��� �� -----");
			System.out.println(" 1.�α׾ƿ� |  2.��ǰ����  |  3.�ֹ��ϱ�  | 4. �ֹ���������  |  5.��ٱ��ϴ��  |  6.��ٱ��Ϻ��� ");
			int menu =Integer.parseInt( sc.nextLine());
			/*switch(menu) {
				case 1 :
					logout(userId);// 
					return;
					//break;
					
				case 2 :
					GoodsController.goodsSelect();//��ü ��ǰ��ȸ
					break;
				case 3 :
					printInputOrder(userId);
					break;
				case 4 :
					OrderController.selectOrdersByUserId(userId);
					break;
				case 5 :
					MenuView.putCart(userId);// 
					break;	
		
				case 6 : 
					viewCart(userId);
					break;
				}*/
		}
		
	}
	
	
	public static void printSubMenu() {
		System.out.println("1. ����   |  2.Ż��   | 9. ������");  //���̵�&���ã��
		
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



