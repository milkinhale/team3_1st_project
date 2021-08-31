package kosta.mvc.view;

import java.util.List;
import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.controller.ReviewController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.dto.Review;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class AdminMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * �Ǹ��ڿ� �޴�
	 * */
	public static void sellerMenu(String sellerId) {
		while(true) {//���ѷ���
			//���� ���� (�۵� Ȯ�� �׽�Ʈ �� �ּ�ó�� �ϱ�!!)
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +sellerId+ " �α��� �� -----");
			//���� ���� (�۵� Ȯ�� �׽�Ʈ �� �ּ�ó�� �ϱ�!!)
			
			System.out.println("-- ������ �޴� --");
			System.out.println("1.���ָ޴�  |  2.�ֹ��޴�  |  3.ȸ���޴�  |  4.����޴�  |  0. �α׾ƿ�");
			int menu =Integer.parseInt(sc.nextLine());
			switch(menu) {
				//���� �޴� 
				case 1:
					liquorAdminMenu(sellerId);
					break;
					
				//�ֹ� �޴� 
				case 2:
					orderAdminMenu(sellerId);
					break;
					
				//ȸ���޴� 
				case 3:
					customerAdminMenu(sellerId);
					break;
					
				//����޴�
				case 4:
					reviewAdminMenu(sellerId);
					break;
				
				//������
				case 0:
					//CustomerMenuView.logout(sellerId);
					logout(sellerId);
					MenuView.menu();
					break;
					
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////
	/**
	 * 1. ���� ���� �޴�
	 * */
	public static void liquorAdminMenu(String sellerId) {
		while(true) {//���ѷ���
			System.out.println("-- ���� ���� �޴� --");
			System.out.println("1.ī�װ��� ����  |  2.���� �̸� �˻�  |  3.���� �߰�  |  4.���� ����  |  5.���� ����  |  0.������");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				//ī�װ��� ���� 
				case 1:
					LiquorController.selectLiquorTable();
					System.out.print("�������� ��ȣ�� �Է��ϼ���> ");
					int liquorTableNo =Integer.parseInt(sc.nextLine());
					LiquorController.liquorsSelectByLiquorType(liquorTableNo);
					break;
					
				//���� �̸� �˻� 
				case 2:
					System.out.print("��ǰ���� �Է��ϼ���> ");
					String name = sc.nextLine();
					LiquorController.liquorSelectByLiquorName(name);
					break;
					
				//���� �߰� 
				case 3:
					System.out.print("�������� ��ȣ: ");
					liquorTableNo = Integer.parseInt(sc.nextLine());
					
					System.out.print("���� �̸�: ");
					String liquorName = sc.nextLine();
					 
					System.out.print("���� ���� : ");
					int liquorPrice = Integer.parseInt(sc.nextLine());
					 
					System.out.print("������� : ");
					String addDate = sc.nextLine();
					 
					LiquorController.insertLiquor(new Liquor(liquorTableNo, liquorName, liquorPrice, addDate));
				
					break;
					
				//���� ���� 
				case 4:
					System.out.print("������ ���� ��ȣ: ");
					int liquorNo = Integer.parseInt(sc.nextLine());
					
					System.out.print("������ ���� �̸�: ");
					liquorName = sc.nextLine();
					 
					System.out.print("������ ���� ���� : ");
					liquorPrice = Integer.parseInt(sc.nextLine());
					
					System.out.print("������ ���� ��� : ");
					int stock = Integer.parseInt(sc.nextLine());
					
					LiquorController.updateLiquor(new Liquor(liquorNo, liquorName, liquorPrice, stock));
					break;
				
				//���� ���� 
				case 5:
					System.out.println("������ ���ֹ�ȣ: ");
					liquorNo = Integer.parseInt(sc.nextLine());
					System.out.println("���� �����Ͻðڽ��ϱ�?   1.Yes   2.No");
					int select = Integer.parseInt(sc.nextLine());
					switch(select) {
						case 1:
							LiquorController.deleteLiquor(liquorNo);
						case 2:
							break;
						default:
							System.out.println("�Է��� ��ȣ�� �ٽ� Ȯ�����ּ���.");
					}
					break;
				
				//������
				case 0:
					sellerMenu(sellerId);
					break;
				
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	
	/**
	 * 2. �ֹ� ���� �޴�
	 * */
	public static void orderAdminMenu(String sellerId) {
		while(true) { //���ѷ���
			System.out.println("-- �ֹ� ���� �޴� --");
			System.out.println("1.��ü �ֹ� ����Ʈ  |  2.ȸ����ȣ�� �ֹ� �˻�  |  3.�ֹ� ���� ����  |  4.�ֹ� ����  |  0.������");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				//��ü �ֹ� ����Ʈ 
				case 1:
					OrderController.orderSelectAll();
					break;
					
				//ȸ����ȣ�� �ֹ� �˻� 
				case 2:
					selectOrdersByUserId();
					break;
					
				//�ֹ� ���� 
				case 3:
					updateOrder();
					break;
					
				//�ֹ� ���� 
				case 4:
					deleteOrder();
					break;
				
				//������
				case 0:
					sellerMenu(sellerId);
					break;
				
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	/**
	 * ȸ���� �ֹ� ��ȸ
	 * */
	public static void selectOrdersByUserId() {
		System.out.print("�ֹ� ��ȸ�Ϸ��� ȸ���� ���̵� �Է����ּ���: ");
		String id = sc.nextLine();
		
		OrderController.selectOrdersByUserId(id);
	}
	
	/**
	 * �ֹ� ���� ����
	 * */
	public static void updateOrder() {
		System.out.print("���¸� �����Ϸ��� �ֹ� ��ȣ�� �Է����ּ���: ");
		int orderNo = Integer.parseInt(sc.nextLine());
		System.out.print("���¸� �Է����ּ���: ");
		String status = sc.nextLine();
		
		OrderController.updateOrder(orderNo, status);
	}
	
	/**
	 * �ֹ� ����
	 * */
	public static void deleteOrder() {
		System.out.print("����Ϸ��� �ֹ� ��ȣ�� �Է����ּ���: ");
		int orderNo = Integer.parseInt(sc.nextLine());
		
		OrderController.deleteOrder(orderNo);
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	/**
	 * 3. ȸ�� ���� �޴�
	 * */
	public static void customerAdminMenu(String sellerId) {
		while(true) {
			System.out.println("-- ȸ�� ���� �޴� --");
			System.out.println("1.��üȸ�� ����Ʈ  |  2.ȸ�� ����  |  0.������");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				//��ü ȸ�� ����Ʈ 
				case 1:
					CustomerController.selectCustomerListAll();
					break;
					
				//ȸ�� ���� 
				case 2:
					System.out.print("������ ȸ�� ���̵� �Է��ϼ���: ");
					String customerId = sc.nextLine();
					CustomerController.deleteCustomer(customerId);
					break;
					
				//������
				case 0:
					sellerMenu(sellerId);
					break;
				
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	
	/**
	 * 4. ���� ���� �޴�
	 * */
	public static void reviewAdminMenu(String sellerId) {
		while(true) {
			System.out.println("-- ���� ���� �޴� --");
			System.out.println("1.��ü ���� ��ȸ  |  2.ȸ���� ���� ��ȸ |  3.���ֹ�ȣ�� ���� ��ȸ  |  4.���� ����  |  5.���� ���� |  0.������");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				//��ü ���� ��ȸ  
				case 1:
					ReviewController.reviewSelectAll();
					break;
					
				//ȸ���� ���� ��ȸ 
				case 2:
					reviewSelectByCustomerId();
					break;
					
				//���ֹ�ȣ�� ���� ��ȸ 
				case 3:
					reviewSelectByLiquorNo();
					break;
					
				//���� ���� 
				case 4:
					updateReivew();
					break;
				
				//���� ���� 
				case 5:
					deleteReivew();
					break;
				
				//������
				case 0:
					sellerMenu(sellerId);
					break;
				
				default:
					System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
	
	/**
	 * ȸ���� ���� ��ȸ
	 * */
	public static void reviewSelectByCustomerId() {
		System.out.print("��ȸ�Ϸ��� ȸ���� ���̵� �Է����ּ���: ");
		String id = sc.nextLine();
		
		ReviewController.reviewSelectByCustomerId(id);
	}
	
	/**
	 * ���ֺ� ���� ��ȸ
	 * */
	public static void reviewSelectByLiquorNo() {
		System.out.print("��ȸ�Ϸ��� ������ ��ȣ�� �Է����ּ���: ");
		int no = Integer.parseInt(sc.nextLine());
		
		ReviewController.reviewSelectByLiquorNo(no);
	}
	
	/**
	 * ���� ����
	 * */
	public static void updateReivew() {
		System.out.println("���並 �����Ϸ��� ������ ��ȣ�� �Է��ϼ���: ");
		int reviewNo = Integer.parseInt(sc.nextLine()); 
		System.out.println("���ο� ���� ������ �Է��ϼ���: ");
		String content = sc.nextLine();
		
		//Review review = new Review(content, reviewNo);
		ReviewController.updateReview(content, reviewNo);
	}
	
	/**
	 * ���� ����
	 * */
	public static void deleteReivew() {
		System.out.println("�����Ϸ��� ������ ��ȣ�� �Է��ϼ���: ");
		int reviewNo = Integer.parseInt(sc.nextLine()); 
		
		ReviewController.deleteReview(reviewNo);
	}
	
	//////////////////////////////
	/**
	 * 0. �α׾ƿ�
	 * */
	public static void logout(String customerId) {
		Session session = new Session(customerId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
	}
	
}
