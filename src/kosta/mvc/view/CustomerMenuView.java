package kosta.mvc.view;

import java.sql.SQLException;
import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.OrderDetail;
import kosta.mvc.model.dto.Orders;
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
					printInputOrder(customerId);
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
					myPageMenu(customerId);
					break;
					
				//�α׾ƿ� 
				case 0 : 
					logout(customerId);
					MenuView.menu();
					break;
					
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
				}
		}
		
	}
	
	/**
	 * 4. �ֹ��ϱ�
	 * */
    public static void printInputOrder(String customerId) {
    	System.out.print("�ֹ���ǰ��ȣ : ");
		 int liquorNo =Integer.parseInt(sc.nextLine());
		 
		 System.out.print("�ֹ����� : ");
		 int count = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("����ּ� : ");
		 String orderAddr = sc.nextLine();

	     System.out.print("���� �ڵ� �Է� : ");
		 int couponNo =Integer.parseInt(sc.nextLine());
		 
		
		 Orders orders = new Orders(0, customerId, null, orderAddr, null, 0, 0);
		 OrderDetail orderDetail = new OrderDetail(0, liquorNo, 0, count, 0);
		 
		 orders.getOrderDetailList().add(orderDetail);
		 
		 OrderController.insertOrders(orders, couponNo);	 
    }
	
    /**
     * 5. ��ٱ��� ���
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
     * 6. ��ٱ��� ����
     * */
	public static void viewCart(String id) {
		//CartController.viewCart(id);
		/*
		 * ��ٱ��� �����ְ�...
		 * ��ĳ�� �Է� �޾Ƽ� 
		 * �ֹ��Ҳ��� 1�� �Է�, ���ư��� 0�� �̷������� �Է� �޾ƾ� �ҰŰ��ƿ�.
		 * 
		 * �����,1�� �Է� ������..
		 * ���� ��Ʈ�ѷ��� 
		 * OrderCart(String customerId, String addr, int couponNo) <- �� �޼ҵ� ����ؾߵǴϱ�...
		 * 
		 * �߰��� ��� �ּ�, ���� ��ȣ �Է� �޾��ֽø� �ɵ�.
		 * */
		/*
		System.out.println("��ٱ��ϸ� �ֹ��Ͻðڽ��ϱ�? (��:1 | �ڷΰ���:0)");
		int input = Integer.parseInt(sc.nextLine());
		
		if(input == 1) {//�Է°��� 1�̸�...
			System.out.print("��� �ּ� :");
			String addr = sc.nextLine();
			System.out.println("������ȣ (������ 0): ");
			int couponNo = Integer.parseInt(sc.nextLine());
			
			//��ٱ��Ϸ� �ֹ��ϴ� ���� ��Ʈ�ѷ��� �޼ҵ� ȣ��.
			OrderController.OrderCart(id, addr, couponNo);
			//id -> ���ǿ��� �����
			//addr -> ��ĳ�ʿ��� �Է� ����
			//couponNo -> ��ĳ�ʿ��� �Է� ����(������ 0 �Է�)
			
		}else {//�Է°��� 1�� �ƴϸ�...
			//�ٽ� �� �޴� ����
			customerMenu(id);
		}
		*/
		
	}
    
	
	/**
	 * 7. ���� �˻� 
	 * */
	
    
	/**
	 * 8. ���������� �޴�
	 * */
	public static void myPageMenu(String customerId) {
		System.out.println("-----����������-----");
		System.out.println("1.�ֹ����� Ȯ��   |  2.�ֹ� ���   |  3.��ٱ��� ����  |  4.��������Ʈ Ȯ��  |  5.ȸ������ ����  |  6.ȸ�� Ż��  |  0. ������");  
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			//�ֹ����� Ȯ�� 
			case 1:
				OrderController.selectOrdersByUserId(customerId);
				break;
				
			//�ֹ� ��� 
			case 2:
				deleteOrder();
				break;
				
			//��ٱ��� ���� 
			case 3:
				break;
				
			//��������Ʈ Ȯ�� 
			case 4:
				break;
				
			//ȸ������ ���� 
			case 5:
				updateCustomer(customerId);
				break;
			
			//ȸ������ Ȯ�� 
			case 6:
				
				
			//ȸ�� Ż�� 
			case 7:
				CustomerController.deleteCustomer(customerId);
				break;
				
			//������ 
			case 0:
				customerMenu(customerId);
				break;

			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	/**
	 * 0. �α׾ƿ�
	 * */
	public static void logout(String customerId) {
		Session session = new Session(customerId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
	}
	
	
	/////////////����������//////////////
	/**
	 * 2. �ֹ� ���
	 * */
	public static void deleteOrder() {
		System.out.print("����Ϸ��� �ֹ� ��ȣ�� �Է����ּ���: ");
		int orderNo = Integer.parseInt(sc.nextLine());
		
		OrderController.deleteOrder(orderNo);
	}
	
	/**
	 * 3. ��ٱ��� ����
	 * */
	
	
	/**
	 * 4. ��������Ʈ Ȯ�� 
	 * */
	
	
	/**
	 * 5. ȸ������ ���� 
	 * */
	public static void updateCustomer(String customerId) {
		System.out.println("1.��й�ȣ   |  2.�̸���   |  3.�ּ�  |  0. ������");
		System.out.println("�����Ͻ� ������ �������ּ���: ");
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			//��й�ȣ ���� 
			case 1:
				System.out.print("���ο� ��й�ȣ�� �Է����ּ���: ");
				String pwd = sc.nextLine();
				CustomerController.updateCustomerPwd(customerId, pwd);
				break;
			
			//�̸��� ���� 
			case 2: 
				System.out.print("���ο� �̸����� �Է����ּ���: ");
				String email = sc.nextLine();
				CustomerController.updateCustomerEmail(customerId, email);
				break;
			
			//�ּ� ����
			case 3:
				System.out.print("���ο� �ּҸ� �Է����ּ���: ");
				String addr = sc.nextLine();
				CustomerController.updateCustomerAddr(customerId, addr);
				break;
		
			//������ 
			case 0:
				myPageMenu(customerId);
				break;
				
			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	/**
	 * 6. ȸ������ Ȯ�� 
	 * */
	public static void checkCustomerInfo(String customerId) {
		
	}

}
