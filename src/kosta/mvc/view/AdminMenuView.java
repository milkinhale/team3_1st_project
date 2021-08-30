package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.Liquor;

public class AdminMenuView {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * �Ǹ��ڿ� �޴�
	 * */
	public static void sellerMenu() {
		System.out.println("-- ������ �޴� --");
		System.out.println("1.���ָ޴�  |  2.�ֹ��޴�  |  3.ȸ���޴�  |  4.����޴�  |  0. ������");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//���� �޴� 
			case 1:
				
				break;
				
			//�ֹ� �޴� 
			case 2:
				break;
				
			//ȸ���޴� 
			case 3:
				break;
				
			//����޴�
			case 4:
				break;
				
			case 0:
				System.exit(0);
				
			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	/**
	 * �Ǹ��� - ���� ���� �޴�
	 * */
	public static void liquorAdminMenu() {
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
				liquorTableNo = sc.nextInt();
				
				System.out.print("���� �̸�: ");
				String liquorName = sc.nextLine();
				 
				System.out.print("���� ���� : ");
				int liquorPrice = sc.nextInt();
				 
				System.out.print("������� : ");
				String addDate = sc.nextLine();
				 
				LiquorController.insertLiquor(new Liquor(liquorTableNo, liquorName, liquorPrice, addDate));
			
				break;
				
			//���� ���� 
			case 4:
				System.out.print("������ ���� ��ȣ: ");
				int liquorNo = sc.nextInt();
				
				System.out.println(liquorNo + "���� ���� �����Դϴ�.");
				LiquorController.liquorSelectByLiquorNo(liquorNo);
				
				System.out.print("������ ���� �̸�: ");
				liquorName = sc.nextLine();
				 
				System.out.print("������ ���� ���� : ");
				liquorPrice = sc.nextInt();
				
				LiquorController.updateLiquor(new Liquor(liquorNo, liquorName, liquorPrice));
				break;
			
			//���� ���� 
			case 5:
				System.out.println("������ ���ֹ�ȣ: ");
				liquorNo = sc.nextInt();
				System.out.println("���� �����Ͻðڽ��ϱ�?   1.Yes   2.No");
				int select = sc.nextInt();
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
				System.exit(0);
			
			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	/**
	 * �Ǹ��� - �ֹ� ���� �޴�
	 * */
	public static void orderAdminMenu() {
		System.out.println("-- �ֹ� ���� �޴� --");
		System.out.println("1.��ü �ֹ� ����Ʈ  |  2.ȸ����ȣ�� �ֹ� �˻�  |  3.�ֹ� ����  |  4.�ֹ� ����  |  0.������");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//��ü �ֹ� ����Ʈ 
			case 1:
				
				break;
				
			//ȸ����ȣ�� �ֹ� �˻� 
			case 2:
				break;
				
			//�ֹ� ���� 
			case 3:
				break;
				
			//�ֹ� ���� 
			case 4:
				break;
			
			//������
			case 0:
				System.exit(0);
				
			default:
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	/**
	 * �Ǹ��� - ȸ�� ���� �޴�
	 * */
	public static void customerAdminMenu() {
		System.out.println("-- ȸ�� ���� �޴� --");
		System.out.println("1.��üȸ�� ����Ʈ  |  2.ȸ�� ����  |  0.������");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//��ü ȸ�� ����Ʈ 
			case 1:
				
				break;
				
			//ȸ�� ���� 
			case 2:
				break;
				
			//������
			case 0:
				System.exit(0);
		}
	}
	
	/**
	 * �Ǹ��� - ���� ���� �޴�
	 * */
	public static void reviewAdminMenu() {
		System.out.println("-- ���� ���� �޴� --");
		System.out.println("1.��ü ���� ��ȸ  |  2.ȸ���� ���� ��ȸ |  3.���ֹ�ȣ�� ���� ��ȸ  |  4.���� ����  |  5.���� ���� |  0.������");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//��ü ���� ��ȸ  
			case 1:
				
				break;
				
			//ȸ���� ���� ��ȸ 
			case 2:
				break;
				
			//���ֹ�ȣ�� ���� ��ȸ 
			case 3:
				break;
				
			//���� ���� 
			case 4:
				break;
			
			//���� ���� 
			case 5:
				break;
			
			//������
			case 9:
				System.exit(0);
		}
	}
	
}
