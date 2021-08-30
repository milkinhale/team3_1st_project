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
	 * 회원 로그인시
	 * */
	public static void customerMenu(String customerId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set객체
			System.out.println("-----" +customerId+ " 로그인 중 -----");
			System.out.println("1.카테고리별 상품보기  |  2.가격대별 상품검색  |  3.상품명 검색  | 4.주문하기  |  5.장바구니 담기  |  6.장바구니 보기  |  7.리뷰 검색  |  8.마이페이지 |  0.로그아웃");
			int menu =Integer.parseInt( sc.nextLine());
			
			
			switch(menu) {
				//카테고리 상품보기 
				case 1 :
					LiquorController.selectLiquorTable();
					System.out.println("양주종류 번호를 입력하세요> ");
					int liquorTableNo =Integer.parseInt(sc.nextLine());
					LiquorController.liquorsSelectByLiquorType(liquorTableNo);
					break;
				//가격대별 검색 
				case 2 :
					System.out.println("원하시는 가격대를 입력하세요> ");
					int price =Integer.parseInt(sc.nextLine());
					LiquorController.liquorsSelectByLiquorPrice(price);
					break;
				
				//상품명 검색 
				 case 3 :
					System.out.println("상품명을 입력하세요> ");
					String name = sc.nextLine();
					LiquorController.liquorSelectByLiquorName(name);
					break;
					
				//주문하기
				case 4 :
					//printInputOrder(customerId);
					break;
				
				//장바구니 담기
				case 5 :
					//OrderController.selectOrdersByUserId(customerId);
					break;
				
				//장바구니 보기  
				case 6 :
					//putCart(userId);
					break;	
				
				//리뷰 검색 
				case 7 : 
					//viewCart(userId);
					break;
				
				//마이페이지 
				case 8 : 
					myPageMenu();
					break;
					
				//로그아웃 (다시 메뉴로)
				case 0 : 
					MenuView.menu();
					break;
					
				default:
					System.out.println("번호를 다시 확인해주세요.");
				}
		}
		
	}
	
	/**
	 * 마이페이지 
	 * */
	public static void myPageMenu() {
		System.out.println("1.주문내역 확인   |  2.주문 취소   |  3.장바구니 비우기  |  4.쿠폰리스트 확인  |  5.회원정보 수정  |  6.회원 탈퇴  |  0. 나가기");  
		int menu =Integer.parseInt( sc.nextLine());
		
		switch(menu) {
			//주문내역 확인 
			case 1:
				break;
				
			//주문 취소 
			case 2:
				break;
				
			//장바구니 비우기 
			case 3:
				break;
				
			//쿠폰리스트 확인 
			case 4:
				break;
				
			//회원정보 수정 
			case 5:
				break;
				
			//회원 탈퇴 
			case 6:
				break;
				
			//나가기 
			case 0:
				break;

			default:
				System.out.println("번호를 다시 확인해주세요.");
		}
	}
	
	
	
	/**
	 * 주문하기
	 * */
    public static void printInputOrder(String userId) {
    	System.out.print("주문상품번호 : ");
		 String goodsId = sc.nextLine();
		 
		 System.out.print("주문수량 : ");
		 int qty = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("배송주소 : ");
		 String address = sc.nextLine();
		 
		
		 /*Orders orders = new Orders(0, null, userId, address, 0);
		 OrderLine orderLine = new OrderLine(0, 0, goodsId, 0, qty, 0);
		 
		 orders.getOrderLineList().add(orderLine);
		 
		 OrderController.insertOrders(orders);*/	 
    }
    
    /**
     * 장바구니 담기
     * */
    public static void putCart(String id) {
		System.out.println("--장바구니 담기 작업 --");
		System.out.print("상품번호 : ");
		String goodsId = sc.nextLine();
		System.out.print("수량 : ");
		int qty = Integer.parseInt(sc.nextLine());
		
		//CartController.putCart(id,goodsId,qty);
	}
	
    /**
     * 장바구니 보기
     * */
	public static void viewCart(String id) {
		//CartController.viewCart(id);
		
		
		
	}
	
}
