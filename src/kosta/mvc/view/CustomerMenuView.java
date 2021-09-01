package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.CartController;
import kosta.mvc.controller.CouponController;
import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.controller.ReviewController;
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
		CouponController.insertCouponTable(customerId, 10);
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +customerId+ " �α��� �� -----");
			System.out.println("1.ī�װ��� ��ǰ����  |  2.���ݴ뺰 ��ǰ�˻�  |  3.��ǰ�� �˻�  | 4.�ֹ��ϱ�  |  5.��ٱ��� ���  |  6.��ٱ��� ����  |  7.����������  |  8.���������� |  0.�α׾ƿ�");
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
					putCart(customerId);
					//OrderController.selectOrdersByUserId(customerId);
					break;
				
				//��ٱ��� ����  
				case 6 :
					viewCart(customerId);
					break;	
				
				//���� �˻� 
				case 7 : 
					reviewMenu(customerId);
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

		System.out.print("������ ����Ͻðڽ��ϱ�?(yes or no) : ");
		String use = sc.nextLine();

		int couponNo = 0;
		if (use.equals("yes")) {
			CouponController.couponSelectAll(customerId);
			System.out.print("���� �ڵ� �Է� : ");
			couponNo = Integer.parseInt(sc.nextLine());
		}

		Orders orders = new Orders(0, customerId, null, orderAddr, null, 0, 0);
		OrderDetail orderDetail = new OrderDetail(0, liquorNo, 0, count, 0);

		orders.getOrderDetailList().add(orderDetail);

		OrderController.insertOrders(orders, couponNo);
		CouponController.useCoupon(couponNo); 
    }
	
    /**
     * 5. ��ٱ��� ���
     * */
    public static void putCart(String id) {
		System.out.println("--��ٱ��� ��� �۾� --");
		//System.out.print("���̵� �Է��ϼ��� : ");
		//String customerId = sc.nextLine();
		System.out.println("���ֹ�ȣ : ");
		int liquorNo = Integer.parseInt(sc.nextLine());
		System.out.print("���� : ");
		int cartCount = Integer.parseInt(sc.nextLine());
		
		CartController.insertCart(id,liquorNo,cartCount);
	}
    
    
    /**
     * 6. ��ٱ��� ����
     * */
	public static void viewCart(String id) {
		System.out.println("--��ٱ��� ����--");
		
		CartController.cartSelectByCustomerId(id);
		
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
		
//		System.out.println("��ٱ��ϸ� �ֹ��Ͻðڽ��ϱ�? (��:1 | �ڷΰ���:0)");
//		int input = Integer.parseInt(sc.nextLine());
//		
//		if(input == 1) {//�Է°��� 1�̸�...
//			System.out.print("��� �ּ� :");
//			String addr = sc.nextLine();
//			System.out.print("������ ����Ͻðڽ��ϱ�?(yes or no) : ");
//			String use = sc.nextLine();
//
//			int couponNo = 0;
//			if (use.equals("yes")) {
//				CouponController.couponSelectAll(id);
//				System.out.print("���� �ڵ� �Է� : ");
//				couponNo = Integer.parseInt(sc.nextLine());
//			}
//			
//			//��ٱ��Ϸ� �ֹ��ϴ� ���� ��Ʈ�ѷ��� �޼ҵ� ȣ��.
//			OrderController.OrderCart(id, addr, couponNo);
//			//id -> ���ǿ��� �����
//			//addr -> ��ĳ�ʿ��� �Է� ����
//			//couponNo -> ��ĳ�ʿ��� �Է� ����(������ 0 �Է�)
//			CouponController.useCoupon(couponNo);
//			
//		}else {//�Է°��� 1�� �ƴϸ�...
//			//�ٽ� �� �޴� ����
//			customerMenu(id);
//		}
		
		
	}
	
	/**
	 * ��ٱ��Ϸ� �ֹ��ϱ�
	 * */
	public static void orderCart(String id, int input) {
		
		
		if(input == 1) {//�Է°��� 1�̸�...
			System.out.print("��� �ּ� :");
			String addr = sc.nextLine();
			System.out.print("������ ����Ͻðڽ��ϱ�?(yes or no) : ");
			String use = sc.nextLine();

			int couponNo = 0;
			if (use.equals("yes")) {
				CouponController.couponSelectAll(id);
				System.out.print("���� �ڵ� �Է� : ");
				couponNo = Integer.parseInt(sc.nextLine());
			}
			
			//��ٱ��Ϸ� �ֹ��ϴ� ���� ��Ʈ�ѷ��� �޼ҵ� ȣ��.
			OrderController.OrderCart(id, addr, couponNo);
			//id -> ���ǿ��� �����
			//addr -> ��ĳ�ʿ��� �Է� ����
			//couponNo -> ��ĳ�ʿ��� �Է� ����(������ 0 �Է�)
			CouponController.useCoupon(couponNo);
			
		}else {//�Է°��� 1�� �ƴϸ�...
			//�ٽ� �� �޴� ����
			customerMenu(id);
		}
	}
    
	
	/**
	 * 7. ���� �޴�
	 * */
	public static void reviewMenu(String customerId) {
		System.out.println("-----���� ������-----");
		System.out.println("1.��ü���� ��ȸ  |  2.���ֺ� ������ȸ   |  3.ȸ���� ������ȸ  |  4.������");  
		int menu =Integer.parseInt(sc.nextLine());
		
		switch(menu) {
		//��ü������ȸ
		case 1:
			ReviewController.reviewSelectAll();
			reviewMenu(customerId);
			break;
			
		//���ֺ� ���� ��ȸ
		case 2:
			System.out.println("���ֹ�ȣ�� �Է��ϼ��� : ");
			int liquorNo = Integer.parseInt(sc.nextLine());
			ReviewController.reviewSelectByLiquorNo(liquorNo);
			reviewMenu(customerId);
			break;
			
		//ȸ���� ���� ��ȸ
		case 3:
			System.out.println("ȸ��ID�� �Է��ϼ��� : ");
			String id = sc.nextLine();
			ReviewController.reviewSelectByCustomerId(id);
			reviewMenu(customerId);
			break;
			
			//������ 
		case 4:
			customerMenu(customerId);
			break;

		default:
			System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			
		}
	}
    
	/**
	 * 8. ���������� �޴�
	 * */
	public static void myPageMenu(String customerId) {
		System.out.println("-----����������-----");
		System.out.println("1.�ֹ����� Ȯ��   |  2.���� �ۼ�  |   3.�ֹ� ���   |  4.��ٱ��� ����  |  5.��������Ʈ Ȯ��  |  6.ȸ������ ����  |  7.ȸ�� Ż��  |  0. ������");  
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			//�ֹ����� Ȯ�� 
			case 1:
				OrderController.selectOrdersByUserId(customerId);
				myPageMenu(customerId);
				break;
				
			//2.�����ۼ�
			case 2:
				putReview(customerId);
				myPageMenu(customerId);
				break;
				
			//�ֹ� ��� 
			case 3:
				deleteOrder();
				myPageMenu(customerId);
				break;
				
			//��ٱ��� ���� 
			case 4:
				deleteCart(customerId);
				myPageMenu(customerId);
				break;
				
			//��������Ʈ Ȯ�� 
			case 5:
				CouponController.couponSelectAll(customerId);
				myPageMenu(customerId);
				break;
				
			//ȸ������ ���� 
			case 6:
				updateCustomer(customerId);
				myPageMenu(customerId);
				break;
			
			//ȸ������ Ȯ�� 
			//case 7:
			//	break;
				
			//ȸ�� Ż�� 
			case 7:
				CustomerController.deleteCustomer(customerId);
				MenuView.menu();
				
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
	 * 2. ���� �ۼ�
	 * */
	public static void putReview(String id) {
		System.out.println("--���� �ۼ��ϱ� --");
		System.out.println("���ֹ�ȣ : ");
		int liquorNo = Integer.parseInt(sc.nextLine());
		System.out.print("������ �Է��ϼ��� : ");
		String content = sc.nextLine();
		
		ReviewController.insertReview(liquorNo, id, content);
	}
	
	/**
	 * 3. �ֹ� ���
	 * */
	public static void deleteOrder() {
		System.out.print("����Ϸ��� �ֹ� ��ȣ�� �Է����ּ���: ");
		int orderNo = Integer.parseInt(sc.nextLine());
		
		OrderController.deleteOrder(orderNo);
	}
	
	/**
	 * 4. ��ٱ��� ����
	 * */
	public static void deleteCart(String id) {
		//System.out.println("������ ��ٱ����� ȸ��ID�� �Է��ϼ���");
		//String customerId = sc.nextLine();
		
		CartController.deleteCart(id);
	}
	
	
	/**
	 * 5. ȸ������ ���� 
	 * */
	public static void updateCustomer(String customerId) {
		System.out.println("1.ȸ������ ����  | 2. ��й�ȣ ����   |  3.�̸��� ����   |  4.�ּ� ���� |  0. ������");
		System.out.println("�����Ͻ� ������ �������ּ���: ");
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			case 1:
				//ȸ�� ���� �����ִ� ��Ʈ�ѷ� �޼ҵ� ����...
				CustomerController.selectCustomerByCustomerId(customerId);
				//���������� �ٽ� ȸ������ ���� �޴� ����ֱ�.
				updateCustomer(customerId);
				break;
		
			//��й�ȣ ���� 
			case 2:
				System.out.print("���ο� ��й�ȣ�� �Է����ּ���: ");
				String pwd = sc.nextLine();
				CustomerController.updateCustomerPwd(customerId, pwd);
				break;
			
			//�̸��� ���� 
			case 3: 
				System.out.print("���ο� �̸����� �Է����ּ���: ");
				String email = sc.nextLine();
				CustomerController.updateCustomerEmail(customerId, email);
				break;
			
			//�ּ� ����
			case 4:
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
