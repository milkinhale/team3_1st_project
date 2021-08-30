package kosta.mvc.model.dto;

public class Coupon {
	private int couponNo;
	private int couponTableNo;
	private int salePersent;
	private String used;
	
	public Coupon() {}
	public Coupon(int salePersent) {
		super();
		this.salePersent = salePersent;
	}
	public Coupon(int couponNo, int salePersent) {
		this(salePersent);
		this.couponNo = couponNo;
	}
	public Coupon(int couponNo, int couponTableNo, int salePersent) {
		this(couponNo, salePersent);
		this.couponTableNo = couponTableNo;
	}
	public Coupon(int couponNo, int couponTableNo, int salePersent, String used) {
		this(couponNo, couponTableNo, salePersent);
		this.used = used;
	}
	
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public int getCouponTableNo() {
		return couponTableNo;
	}
	public void setCouponTableNo(int couponTableNo) {
		this.couponTableNo = couponTableNo;
	}
	public int getSalePersent() {
		return salePersent;
	}
	public void setSalePersent(int salePersent) {
		this.salePersent = salePersent;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("���� ��ȣ =");
		builder.append(couponNo);
		builder.append(", ������ =");
		builder.append(salePersent);
		return builder.toString();
	}
}
