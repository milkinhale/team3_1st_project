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
		// TODO Auto-generated constructor stub
	}
	
	public Liquor(int liquorNo, int liquorTableNo, String liquorName, int liquorPrice, int stock, String addDate) {
		super();
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
		builder.append("Liquor [liquorNo=");
		builder.append(liquorNo);
		builder.append(", liquorTableNo=");
		builder.append(liquorTableNo);
		builder.append(", liquorName=");
		builder.append(liquorName);
		builder.append(", liquorPrice=");
		builder.append(liquorPrice);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", addDate=");
		builder.append(addDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
