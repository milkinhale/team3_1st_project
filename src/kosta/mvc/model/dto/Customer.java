package kosta.mvc.model.dto;

public class Customer {
	private String customerId;
	private String pwd;
	private String customerName;
	private String birth;
	private String email;
	private String addr;
	private String contact;
	private String signDate;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", email=");
		builder.append(email);
		builder.append(", addr=");
		builder.append(addr);
		builder.append(", contact=");
		builder.append(contact);
		builder.append(", signDate=");
		builder.append(signDate);
		builder.append("]");
		return builder.toString();
	}
	
}
