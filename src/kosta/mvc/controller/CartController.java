package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Cart;
import kosta.mvc.model.service.CartService;
import kosta.mvc.view.FailView;
import kosta.mvc.view.ReviewCartEndview;
import kosta.mvc.view.SuccessView;


public class CartController {
  private static CartService cartService = new CartService();
  
  /**
   * 회원 id별로 장바구니 조회
   * */
  public static void cartSelectByCustomerId(String customerId) {
	  try {
			List<Cart> cartList = cartService.cartSelectByCustomerId(customerId);
			ReviewCartEndview.printCartByCustomerId(cartList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
  }
  
  /**
   * 장바구니 담기
   * */
  public static void insertCart(Cart cart) {
	  try {
		  cartService.insertCart(cart);
		  ReviewCartEndview.meesegePrint("등록되었습니다.");
	  }catch(Exception e) {
		  FailView.errorMessage(e.getMessage());
	  }
  }
  
  /**
   * 장바구니 삭제하기
   * */
  public static void deleteCart(int cartNo) {
	  try {
		  cartService.deleteCart(cartNo);
		  ReviewCartEndview.meesegePrint("삭제되었습니다.");
	  }catch(Exception e) {
		  FailView.errorMessage(e.getMessage());
	  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /*
   public static void putCart(String id, String goodsId, int quantity) {
		
		/*try {
			//상품번호에 해당 상품찾기
			Goods goods = goodsService.goodsSelectBygoodsId(goodsId);
			//A01	새우깡	1500	4	20/09/04
			
			if(goods.getStock() < quantity) {
				throw new SQLException("재고량 부족으로 장바구니에 담을수 없습니다.");
			}
			//id에 해당하는 세션찾기
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);	
			
			//세션에서 장바구니 찾기
			Map<Goods, Integer> cart =	(Map<Goods,Integer>)session.getAttribute("cart"); //상품 , 수량 저장 
			
			//장바구니가 없으면 장바구니 생성
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}
			
			
			//장바구니에서 상품찾기
			Integer oldQuantity = cart.get(goods); //goods는 key 정보
			if(oldQuantity != null) { //장바구니에 이미 상품이 있다면
				quantity += oldQuantity; //수량을 누적
			}
			
			cart.put(goods, quantity); //장바구니에 상품 넣기
			EndView.printMessage("장바구니에 담았습니다");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}*/
   
   /**
    * 장바구니 보기
    * */
   /*public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);
		
		Map<Goods,Integer> cart = (Map<Goods, Integer>) session.getAttribute("cart");
		if(cart == null ) { // 장바구니가 없는 고객
			FailView.errorMessage("장바구니가 비었습니다");
		}else {
			EndView.printViewCart(id , cart);
		}
	}*/
}




