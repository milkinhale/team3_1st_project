package kosta.mvc.model.dto;

public class LiquorTable {
	private int liquorTableNo;
	private String liquorType;
	private String origin;
	
	public LiquorTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LiquorTable(int liquorTableNo, String liquorType, String origin) {
		super();
		this.liquorTableNo = liquorTableNo;
		this.liquorType = liquorType;
		this.origin = origin;
	}

	public int getLiquorTableNo() {
		return liquorTableNo;
	}

	public void setLiquorTableNo(int liquorTableNo) {
		this.liquorTableNo = liquorTableNo;
	}

	public String getLiquorType() {
		return liquorType;
	}

	public void setLiquorType(String liquorType) {
		this.liquorType = liquorType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LiquorTable [liquorTableNo=");
		builder.append(liquorTableNo);
		builder.append(", liquorType=");
		builder.append(liquorType);
		builder.append(", origin=");
		builder.append(origin);
		builder.append("]");
		return builder.toString();
	}
	
	

}
