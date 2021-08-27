package kosta.mvc.model.dto;

public class Orders {
	private int orderNo;
	private String customerId;
	private String orderDate;
	private String orderAddr;
	private String orderStatus;
	private int finalPrice;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderNo, String customerId, String orderDate, String orderAddr, String orderStatus,
			int finalPrice) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.orderAddr = orderAddr;
		this.orderStatus = orderStatus;
		this.finalPrice = finalPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [orderNo=");
		builder.append(orderNo);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderAddr=");
		builder.append(orderAddr);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", finalPrice=");
		builder.append(finalPrice);
		builder.append("]");
		return builder.toString();
	}
	
	
}
