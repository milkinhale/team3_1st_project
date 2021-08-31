package kosta.mvc.model.dto;

public class Liquor {
	private int liquorNo;
	private int liquorTableNo;
	private String liquorName;
	private int liquorPrice;
	private int stock;
	private String addDate;
	
	public Liquor() {
		super();
	}
	
	public Liquor(int liquorNo, int stock) {
		this.liquorNo = liquorNo;
		this.stock = stock;
	}
	
	public Liquor(int liquorNo, String liquorName, int liquorPrice) {
		this.liquorNo = liquorNo;
		this.liquorName = liquorName;
		this.liquorPrice = liquorPrice;
	}
	
	public Liquor(int liquorTableNo, String liquorName, int liquorPrice, String addDate) {
		this.liquorTableNo = liquorTableNo;
		this.liquorName = liquorName;
		this.liquorPrice = liquorPrice;
		this.addDate = addDate;
	}
	
	public Liquor(int liquorNo, String liquorName, int liquorPrice, int stock) {
		this.liquorNo = liquorNo;
		this.liquorName = liquorName;
		this.liquorPrice = liquorPrice;
		this.stock = stock;
	}
	
	
	public Liquor(int liquorNo, int liquorTableNo, String liquorName, int liquorPrice, int stock, String addDate) {
		this.liquorNo = liquorNo;
		this.liquorTableNo = liquorTableNo;
		this.liquorName = liquorName;
		this.liquorPrice = liquorPrice;
		this.stock = stock;
		this.addDate = addDate;
	}


	
	public int getLiquorNo() {
		return liquorNo;
	}
	public void setLiquorNo(int liquorNo) {
		this.liquorNo = liquorNo;
	}
	public int getLiquorTableNo() {
		return liquorTableNo;
	}
	public void setLiquorTableNo(int liquorTableNo) {
		this.liquorTableNo = liquorTableNo;
	}
	public String getLiquorName() {
		return liquorName;
	}
	public void setLiquorName(String liquorName) {
		this.liquorName = liquorName;
	}
	public int getLiquorPrice() {
		return liquorPrice;
	}
	public void setLiquorPrice(int liquorPrice) {
		this.liquorPrice = liquorPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("*��ǰ ��ȣ: ");
		builder.append(liquorNo);
		builder.append("\t���� ��ȣ: ");
		builder.append(liquorTableNo);
		builder.append("\t�̸�: ");
		builder.append(liquorName);
		builder.append("\t����: ");
		builder.append(liquorPrice);
		builder.append("\t���: ");
		builder.append(stock);
		builder.append("\t�����: ");
		builder.append(addDate);
		return builder.toString();
	}
	
	
}
