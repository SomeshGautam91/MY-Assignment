package org.training.cdac.pojo;

public class BookIssue {
	
	private String bookName;
	private int memberId;
	private String issueDate;
	private String returnDate;
	private int daysRemain;
	
	public BookIssue(String bookName, int memberId, String issueDate,
			String returnDate,int daysRemain) {
		super();
		this.bookName = bookName;
		this.memberId = memberId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.daysRemain=daysRemain;
	}

	public int getDaysRemain() {
		return daysRemain;
	}

	public void setDaysRemain(int daysRemain) {
		this.daysRemain = daysRemain;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	

}
