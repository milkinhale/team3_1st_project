package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.Cart;
import kosta.mvc.model.service.CartService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;


public class CartController {
  private static CartService cartService = new CartService();
  
  /**
   * ȸ�� id���� ��ٱ��� ��ȸ
   * */
  public static void cartSelectByCustomerId(String customerId) {
	  try {
			List<Cart> cartList = cartService.cartSelectByCustomerId(customerId);
			EndView.printCartByCustomerId(cartList);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
  }
  
  /**
   * ��ٱ��� ���
   * */
  public static void insertCart(Cart cart) {
	  try {
		  cartService.insertCart(cart);
		  EndView.meesegePrint("��ϵǾ����ϴ�.");
	  }catch(Exception e) {
		  FailView.errorMessage(e.getMessage());
	  }
  }
  
  /**
   * ��ٱ��� �����ϱ�
   * */
  public static void deleteCart(String customerId) {
	  try {
		  cartService.deleteCart(customerId);
		  EndView.meesegePrint("�����Ǿ����ϴ�.");
	  }catch(Exception e) {
		  FailView.errorMessage(e.getMessage());
	  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /*
   public static void putCart(String id, String goodsId, int quantity) {
		
		/*try {
			//��ǰ��ȣ�� �ش� ��ǰã��
			Goods goods = goodsService.goodsSelectBygoodsId(goodsId);
			//A01	�����	1500	4	20/09/04
			
			if(goods.getStock() < quantity) {
				throw new SQLException("��� �������� ��ٱ��Ͽ� ������ �����ϴ�.");
			}
			//id�� �ش��ϴ� ����ã��
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);	
			
			//���ǿ��� ��ٱ��� ã��
			Map<Goods, Integer> cart =	(Map<Goods,Integer>)session.getAttribute("cart"); //��ǰ , ���� ���� 
			
			//��ٱ��ϰ� ������ ��ٱ��� ����
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}
			
			
			//��ٱ��Ͽ��� ��ǰã��
			Integer oldQuantity = cart.get(goods); //goods�� key ����
			if(oldQuantity != null) { //��ٱ��Ͽ� �̹� ��ǰ�� �ִٸ�
				quantity += oldQuantity; //������ ����
			}
			
			cart.put(goods, quantity); //��ٱ��Ͽ� ��ǰ �ֱ�
			EndView.printMessage("��ٱ��Ͽ� ��ҽ��ϴ�");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}*/
   
   /**
    * ��ٱ��� ����
    * */
   /*public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);
		
		Map<Goods,Integer> cart = (Map<Goods, Integer>) session.getAttribute("cart");
		if(cart == null ) { // ��ٱ��ϰ� ���� ��
			FailView.errorMessage("��ٱ��ϰ� ������ϴ�");
		}else {
			EndView.printViewCart(id , cart);
		}
	}*/
}




