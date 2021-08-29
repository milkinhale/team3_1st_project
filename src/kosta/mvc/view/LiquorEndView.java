package kosta.mvc.view;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.Liquor;


public class LiquorEndView {
	public static void printLiquorList(List<Liquor> liquorList) {
		System.out.println("------해당 조건에 따라 " + liquorList.size() + "건의 상품이 조회되었어요.-----");
		for (Liquor liquor : liquorList) {
			System.out.println(liquor);
		}
		System.out.println();
	}
	
	public static void printLiquor(Liquor liquorDTO) {
		System.out.println("해당 상품 정보입니다.");
		System.out.println(liquorDTO + "굈");
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}

}
