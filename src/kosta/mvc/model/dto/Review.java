package kosta.mvc.model.dto;

public class Review {
	private String reviewNo;
	private int liquorNo;
	private String customerId;
	private String writeDate;
	private String content;
	
	public Review(String reviewNo, int liquorNo, String customerId, String writeDate, String content) {
		super();
		this.reviewNo = reviewNo;
		this.liquorNo = liquorNo;
		this.customerId = customerId;
		this.writeDate = writeDate;
		this.content = content;
	}
	
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getLiquorNo() {
		return liquorNo;
	}
	public void setLiquorNo(int liquorNo) {
		this.liquorNo = liquorNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewNo=");
		builder.append(reviewNo);
		builder.append(", liquorNo=");
		builder.append(liquorNo);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", writeDate=");
		builder.append(writeDate);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
