package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.LiquorController;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.Liquor;

public class AdminMenuView {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * 판매자용 메뉴
	 * */
	public static void sellerMenu() {
		System.out.println("-- 관리자 메뉴 --");
		System.out.println("1.양주메뉴  |  2.주문메뉴  |  3.회원메뉴  |  4.리뷰메뉴  |  0. 나가기");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//양주 메뉴 
			case 1:
				
				break;
				
			//주문 메뉴 
			case 2:
				break;
				
			//회원메뉴 
			case 3:
				break;
				
			//리뷰메뉴
			case 4:
				break;
				
			case 0:
				System.exit(0);
				
			default:
				System.out.println("번호를 다시 확인해주세요.");
		}
	}
	
	/**
	 * 판매자 - 양주 관리 메뉴
	 * */
	public static void liquorAdminMenu() {
		System.out.println("-- 양주 관리 메뉴 --");
		System.out.println("1.카테고리별 보기  |  2.양주 이름 검색  |  3.양주 추가  |  4.양주 수정  |  5.양주 삭제  |  0.나가기");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//카테고리별 보기 
			case 1:
				LiquorController.selectLiquorTable();
				System.out.print("양주종류 번호를 입력하세요> ");
				int liquorTableNo =Integer.parseInt(sc.nextLine());
				LiquorController.liquorsSelectByLiquorType(liquorTableNo);
				break;
				
			//양주 이름 검색 
			case 2:
				System.out.print("상품명을 입력하세요> ");
				String name = sc.nextLine();
				LiquorController.liquorSelectByLiquorName(name);
				break;
				
			//양주 추가 
			case 3:
				System.out.print("양주종류 번호: ");
				liquorTableNo = sc.nextInt();
				
				System.out.print("양주 이름: ");
				String liquorName = sc.nextLine();
				 
				System.out.print("양주 가격 : ");
				int liquorPrice = sc.nextInt();
				 
				System.out.print("등록일자 : ");
				String addDate = sc.nextLine();
				 
				LiquorController.insertLiquor(new Liquor(liquorTableNo, liquorName, liquorPrice, addDate));
			
				break;
				
			//양주 수정 
			case 4:
				System.out.print("수정할 양주 번호: ");
				int liquorNo = sc.nextInt();
				
				System.out.println(liquorNo + "번의 양주 정보입니다.");
				LiquorController.liquorSelectByLiquorNo(liquorNo);
				
				System.out.print("수정할 양주 이름: ");
				liquorName = sc.nextLine();
				 
				System.out.print("수정할 양주 가격 : ");
				liquorPrice = sc.nextInt();
				
				LiquorController.updateLiquor(new Liquor(liquorNo, liquorName, liquorPrice));
				break;
			
			//양주 삭제 
			case 5:
				System.out.println("삭제할 양주번호: ");
				liquorNo = sc.nextInt();
				System.out.println("정말 삭제하시겠습니까?   1.Yes   2.No");
				int select = sc.nextInt();
				switch(select) {
					case 1:
						LiquorController.deleteLiquor(liquorNo);
					case 2:
						break;
					default:
						System.out.println("입력한 번호를 다시 확인해주세요.");
				}
				break;
			
			//나가기
			case 0:
				System.exit(0);
			
			default:
				System.out.println("번호를 다시 확인해주세요.");
		}
	}
	
	/**
	 * 판매자 - 주문 관리 메뉴
	 * */
	public static void orderAdminMenu() {
		System.out.println("-- 주문 관리 메뉴 --");
		System.out.println("1.전체 주문 리스트  |  2.회원번호로 주문 검색  |  3.주문 수정  |  4.주문 삭제  |  0.나가기");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//전체 주문 리스트 
			case 1:
				
				break;
				
			//회원번호로 주문 검색 
			case 2:
				break;
				
			//주문 수정 
			case 3:
				break;
				
			//주문 삭제 
			case 4:
				break;
			
			//나가기
			case 0:
				System.exit(0);
				
			default:
				System.out.println("번호를 다시 확인해주세요.");
		}
	}
	
	/**
	 * 판매자 - 회원 관리 메뉴
	 * */
	public static void customerAdminMenu() {
		System.out.println("-- 회원 관리 메뉴 --");
		System.out.println("1.전체회원 리스트  |  2.회원 강퇴  |  0.나가기");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//전체 회원 리스트 
			case 1:
				
				break;
				
			//회원 강퇴 
			case 2:
				break;
				
			//나가기
			case 0:
				System.exit(0);
		}
	}
	
	/**
	 * 판매자 - 리뷰 관리 메뉴
	 * */
	public static void reviewAdminMenu() {
		System.out.println("-- 리뷰 관리 메뉴 --");
		System.out.println("1.전체 리뷰 조회  |  2.회원별 리뷰 조회 |  3.양주번호별 리뷰 조회  |  4.리뷰 수정  |  5.리뷰 삭제 |  0.나가기");
		int menu =Integer.parseInt( sc.nextLine());
		switch(menu) {
			//전체 리뷰 조회  
			case 1:
				
				break;
				
			//회원별 리뷰 조회 
			case 2:
				break;
				
			//양주번호별 리뷰 조회 
			case 3:
				break;
				
			//리뷰 수정 
			case 4:
				break;
			
			//리뷰 삭제 
			case 5:
				break;
			
			//나가기
			case 9:
				System.exit(0);
		}
	}
	
}
