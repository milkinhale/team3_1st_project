package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.Liquor;
import kosta.mvc.model.service.LiquorService;
import kosta.mvc.model.service.LiquorTableService;
import kosta.mvc.view.FailView;
import kosta.mvc.view.LiquorEndView;

public class LiquorTableController {
	
	static LiquorTableService liquorTableService = new LiquorTableService();
	
	public static void selectLiquorTable() {
		try {
			liquorTableService.selectLiquorTable();
			LiquorEndView.messagePrint("���� ī�װ� �Դϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
