package kosta.mvc.view;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.dto.LiquorTable;


public class LiquorEndView {
	public static void printLiquorList(List<Liquor> liquorList) {
		System.out.println("------�ش� ���ǿ� ���� " + liquorList.size() + "���� ��ǰ�� ��ȸ�Ǿ����.-----");
		for (Liquor liquor : liquorList) {
			System.out.println(liquor);
		}
		System.out.println();
	}
	
	public static void printLiquorTableList(List<LiquorTable> liquorTableList) {
		System.out.println("------��ǰ���� ����Դϴ�------");
		for (LiquorTable liquorTable : liquorTableList) {
			System.out.println(liquorTable);
		}
		System.out.println();
	}

	public static void printLiquor(Liquor liquorDTO) {
		System.out.println("�ش� ��ǰ �����Դϴ�.");
		System.out.println(liquorDTO + "�n");
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}

}
