package co.project.bookrental.vo;

import java.sql.Date;

public class BookRentalVO {
	private Date rentalDate;
	private String bookCode;
	private String memberId;
	private Date returnDate;
	private String bookName;
	private int rentalNumber;
	
	public BookRentalVO() {
		// TODO Auto-generated constructor stub
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getRentalNumber() {
		return rentalNumber;
	}

	public void setRentalNumber(int rentalNumber) {
		this.rentalNumber = rentalNumber;
	}
	
	
}
