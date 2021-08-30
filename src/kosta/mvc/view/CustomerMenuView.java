package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class CustomerMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * ȸ�� �α��ν�
	 * */
	public static void customerMenu(String customerId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +customerId+ " �α��� �� -----");
			System.out.println("1.ī�װ��� ��ǰ����  |  2.���ݴ뺰 ��ǰ�˻�  |  3.��ǰ�� �˻�  | 4.�ֹ��ϱ�  |  5.��ٱ��� ���  |  6.��ٱ��� ����  |  7.���� �˻�  |  8.���������� |  0.�α׾ƿ�");
			int menu =Integer.parseInt( sc.nextLine());
			
			
			switch(menu) {
				//ī�װ� ��ǰ���� 
				case 1 :
					LiquorController.selectLiquorTable();
					System.out.println("�������� ��ȣ�� �Է��ϼ���> ");
					int liquorTableNo =Integer.parseInt(sc.nextLine());
					LiquorController.liquorsSelectByLiquorType(liquorTableNo);
					break;
				//���ݴ뺰 �˻� 
				case 2 :
					System.out.println("���Ͻô� ���ݴ븦 �Է��ϼ���> ");
					int price =Integer.parseInt(sc.nextLine());
					LiquorController.liquorsSelectByLiquorPrice(price);
					break;
				
				//��ǰ�� �˻� 
				 case 3 :
					System.out.println("��ǰ���� �Է��ϼ���> ");
					String name = sc.nextLine();
					LiquorController.liquorSelectByLiquorName(name);
					break;
					
				//�ֹ��ϱ�
				case 4 :
					//printInputOrder(customerId);
					break;
				
				//��ٱ��� ���
				case 5 :
					//OrderController.selectOrdersByUserId(customerId);
					break;
				
				//��ٱ��� ����  
				case 6 :
					//putCart(userId);
					break;	
				
				//���� �˻� 
				case 7 : 
					//viewCart(userId);
					break;
				
				//���������� 
				case 8 : 
					myPageMenu();
					break;
					
				//�α׾ƿ� (�ٽ� �޴���)
				case 0 : 
					MenuView.menu();
					break;
					
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
				}
		}
		
	}
	
	/**
	 * ���������� 
	 * */
	public static void myPageMenu() {
		System.out.println("1.�ֹ����� Ȯ��   |  2.�ֹ� ���   |  3.��ٱ��� ����  |  4.��������Ʈ Ȯ��  |  5.ȸ������ ����  |  6.ȸ�� Ż��  |  0. ������");  
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			//�ֹ����� Ȯ�� 
			case 1:
				break;
				
			//�ֹ� ��� 
			case 2:
				break;
				
			//��ٱ��� ���� 
			case 3:
				break;
				
			//��������Ʈ Ȯ�� 
			case 4:
				break;
				
			//ȸ������ ���� 
			case 5:
				break;
				
			//ȸ�� Ż�� 
			case 6:
				break;
				
			//������ 
			case 0:
				break;

			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
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
		
		//CartController.putCart(id,goodsId,qty);
	}
	
    /**
     * ��ٱ��� ����
     * */
	public static void viewCart(String id) {
		//CartController.viewCart(id);
		
		
		
	}
	
}
