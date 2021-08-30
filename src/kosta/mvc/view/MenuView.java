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
	 * 첫 화면 기능
	 * */
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			System.out.println("=== KOSTA liqour Shopping Mall ===");
			System.out.println("1. 회원가입   |   2. 로그인   |   3. 아이디 찾기   |   4. 비밀번호 찾기   |  9. 종료");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			//등록하기
			case 1 :
				MenuView.register(); 
				break;
			//로그인
			case 2 :
				MenuView.login();
				break;
				
			//아이디 찾기 
			case 3 :
				
				break;
				
			//비밀번호 찾기 
			case 4 :
				
				break;
			
			//종료하기
			case 9 : 
				System.exit(0);
			}
		}
	}
	
	
	/**
	 * 유저 로그인 시 출력 
	 * */
	public static void printUserMenu(String customerId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set객체
			System.out.println("-----" +customerId+ " 로그인 중 -----");
			System.out.println("1.카테고리별 상품보기  |  2.가격대별 상품검색  |  3.상품명 검색  | 4.주문하기  |  5.장바구니 담기  |  6.장바구니 보기  |  7.리뷰 검색  |  8.마이페이지 |  9.로그아웃");
			int menu =Integer.parseInt( sc.nextLine());
			
			/*
			switch(menu) {
				//카테고리 상품보기 
				case 1 :
					logout(userId);// 
					return;
					//break;
				
				//가격대별 검색 
				case 2 :
					GoodsController.goodsSelect();//전체 상품조회
					break;
				
				//상품명 검색 
				 case 3 :
					printInputOrder(userId);
					break;
					
				//주문하기
				case 4 :
					printInputOrder(userId);
					break;
				
				//장바구니 담기
				case 5 :
					OrderController.selectOrdersByUserId(userId);
					break;
				
				//장바구니 보기  
				case 6 :
					MenuView.putCart(userId);// 
					break;	
				
				//리뷰 검색 
				case 7 : 
					viewCart(userId);
					break;
				
				//마이페이지 
				case 8 : 
					viewCart(userId);
					break;
					
				//로그아웃 (다시 메뉴로)
				case 9 : 
					MenuView.menu();
					break;
				}*/
		}
		
	}
	
	
	public static void printSubMenu() {
		System.out.println("1. 수정   |  2.탈퇴   | 9. 나가기");  
		
		//이메일 수정 
		System.out.print("아이디: ");
		String customerId = sc.nextLine();
		System.out.print("이메일");
		String customerEmail = sc.nextLine();
		
		System.out.print("변경할 이메일 입력: ");
		String customerEmail = sc.nextLine();
		
		// 주소 수정 
		
		//비밀번호 수정 
		
		//회원탈퇴
		System.out.print("아이디");
		String customerId = sc.nextLine();
		
		
	}
	
	public static void printAdminMenu() {
		System.out.println("-- 관리자 메뉴 --");
		System.out.println("1. ID로 검색   |  2.이름으로 검색  | 3.전체 검색  |  9. 나가기");
		
	}
	
	/**
	 * 회원가입
	 * */
	public static void register() {
		System.out.print("아이디 : ");
		 String cutomerId = sc.nextLine();
		 
		 System.out.print("비번 : ");
		 String Pwd = sc.nextLine();
		 
		 System.out.print("이름 : ");
		 String cutomerName = sc.nextLine();
		 
		 System.out.print("생일 : ");
		 String birth = sc.nextLine();
		 
		 System.out.print("이메일 : ");
		 String email = sc.nextLine();
		 
		 System.out.print("주소 : ");
		 String addr = sc.nextLine();
		 
		 System.out.print("연락처 : ");
		 String contact = sc.nextLine();
		 
		 Customer customer = new Customer(cutomerId, Pwd, cutomerName, birth, email, addr, contact, addr, contact);
		 CustomerController.register(customer);
	}
	
	/**
	 * 로그인 메뉴
	 * */
	public static void login() {
		 System.out.print("아이디 : ");
		 String customerId = sc.nextLine();
		 
		 System.out.print("비번 : ");
		 String customerPwd = sc.nextLine();
		 
		 CustomerController.login(customerId, customerPwd); 
	}
	
	/**
	 * 로그아웃
	 * */
	public static void logout(String customerId) {
		Session session = new Session(customerId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
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
		
		CartController.putCart(id,goodsId,qty);
	
		
	}
	
    /**
     * 장바구니 보기
     * */
	public static void viewCart(String id) {
		//CartController.viewCart(id);
		
		
		
	}
}



