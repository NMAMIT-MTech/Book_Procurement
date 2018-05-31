package book;

import book.Book;

public interface BookLibrarian {
	
	public void addBook();

	public void updateBook(int new1);

	public void deleteBook(int ISBN );
	
	public void requestBook();
	
	public void displayBook(Book book);
}
