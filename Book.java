package book;

import java.util.Date;

public class Book {
	private int ISBN;
	private String title;
	private String author;
	private String publisher;
	private String volume;
	private String purchase_date;
	private String book_type;
	private int flag1;
	private int no_copies;
	private String requested_date;
	private String requested_by;
	private String e_mail;
	
	// alt+shift+s to generate getter-setters
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	
	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}
	
	
	public int getNo_copies() {
		return no_copies;
	}

	public void setNo_copies(int no_copies) {
		this.no_copies = no_copies;
	}

	public String getRequested_date() {
		return requested_date;
	}

	public void setRequested_date(String requested_date) {
		this.requested_date = requested_date;
	}

	public String getRequested_by() {
		return requested_by;
	}

	public void setRequested_by(String requested_by) {
		this.requested_by = requested_by;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", volume=" + volume + ", purchase_date=" + purchase_date + ", book_type=" + book_type + ", flag1="
				+ flag1 + ", no_copies=" + no_copies + ", requested_date=" + requested_date + ", requested_by="
				+ requested_by + ", e_mail=" + e_mail + "]";
	}

}
