package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import book.Book; 
public class Book_procurement implements BookLibrarian {
	// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/book";
		String user = "root";
		String password = "root123";
		Connection conn;
		PreparedStatement statement;
		
		
		@Override
		public void addBook() {
			Statement st;
			try {
				conn = DriverManager.getConnection(url, user, password);
				st = (Statement) conn.createStatement();
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the book details:\n");
				Book b=new Book();
				System.out.println("ISBN:");
				b.setISBN(sc.nextInt());
				System.out.println("Book Title:");
				b.setTitle(sc.next());
				System.out.println("Book Author:");
				b.setAuthor(sc.next());
				System.out.println("Book Publisher:");
				b.setPublisher(sc.next());
				System.out.println("Book Volume:");
				b.setVolume(sc.next());
				System.out.println("Book Purchase Date(YYYY/MM/DD):"); 
			    b.setPurchase_date(sc.next());
				System.out.println("Book Category:");
				b.setBook_type(sc.next());
				String sql = "INSERT INTO book values("+b.getISBN()+",'"+b.getTitle()+"','"+b.getAuthor()+"','"+b.getPublisher()+"','"+b.getVolume()+"',DATE_FORMAT('"+b.getPurchase_date()+"','%Y-%m-%d'),'"+b.getBook_type()+"')";
								
				int row = st.executeUpdate(sql);
				if (row > 0) {
					System.out.println("Book added to the catalog successfully");
				}
				//conn.close();
			} catch (Exception ex) {
				System.out.println(ex);
				
				ex.printStackTrace();
			} 

		}


		@Override
		public void updateBook(int new1) {
			// TODO Auto-generated method stub
			Book b2 = new Book();
			String query = "SELECT * FROM book where ISBN="+new1;

			// create the java statement
			Statement st;
			try {
				conn = DriverManager.getConnection(url, user, password);
				st = (Statement) conn.createStatement();
				Scanner sc=new Scanner(System.in);
				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);
				System.out.format("ISBN\t Title\t Author\t Publisher\t Volume\t Book_type\n");
				
				while (rs.next()) {
				int ISBN = rs.getInt("ISBN");
				b2.setISBN(ISBN);
				String title = rs.getString("title");
				b2.setTitle(title);
				String author = rs.getString("author");
				b2.setAuthor(author);
				String publisher = rs.getString("publisher");
				b2.setPublisher(publisher);
				String volume = rs.getString("volume");
				b2.setVolume(volume);
				String date=rs.getString("purchase_date");
				String book_type = rs.getString("book_type");
				b2.setVolume(book_type);
				System.out.format("%d\t%s\t%s\t%s\t%s\t%s\n*****\n",ISBN,title,author,publisher,volume,book_type);
				}
				System.out.format("Update new Detils\n");
				
				
				System.out.println("Book Title:");
				b2.setTitle(sc.next());
				System.out.println("Book Author:");
				b2.setAuthor(sc.next());
				System.out.println("Book Publisher:");
				b2.setPublisher(sc.next());
				System.out.println("Book Volume:");
				b2.setVolume(sc.next());
				System.out.println("Book Purchase Date(YYYY/MM/DD):"); 
			    b2.setPurchase_date(sc.next());
				System.out.println("Book Category:");
				b2.setBook_type(sc.next());
				String sql = "Update book set title='"+b2.getTitle()+"',author='"+b2.getAuthor()+"',publisher='"+b2.getPublisher()+"',volume='"+b2.getVolume()+"',purchase_date=DATE_FORMAT('"+b2.getPurchase_date()+"','%Y-%m-%d'),book_type='"+b2.getBook_type()+"' where ISBN="+new1;
								
				int row = st.executeUpdate(sql);
				if (row > 0) {
					System.out.println("Updated to the catalog successfully");
				}
				
			//	studentsTable.setModel(DbUtils.resultSetToTableModel(result));
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void deleteBook(int ISBN) {
			// TODO Auto-generated method stub
			Statement st1;
			try {
				
				
					conn = DriverManager.getConnection(url, user, password);
					st1 = (Statement) conn.createStatement();
				// create our java preparedstatement using a sql update query
				String sql = "Delete from book WHERE ISBN ="+ISBN;
				
				st1.executeUpdate(sql);
				System.out.println("Book is removed from the Library stock\n");
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			// TODO Auto-generated method stub

		}

	
		public void requestBook(){
		
			Statement st1;
			try {	
					conn = DriverManager.getConnection(url, user, password);
					st1 = (Statement) conn.createStatement();
			System.out .println("Enter the requested book details:\n");
			Scanner sc=new Scanner(System.in);
			Book b1=new Book();
			System.out.println("Book Title:");
			b1.setTitle(sc.next());
			System.out.println("Book Author:");
			b1.setAuthor(sc.next());
			System.out.println("Book Publisher:");
			b1.setPublisher(sc.next());
			System.out.println("Book Volume:");
			b1.setVolume(sc.next());
			System.out.println("No. of copies:");
			b1.setNo_copies(sc.nextInt());
			System.out.println("Request Date(YYYY/MM/DD):");
			b1.setRequested_date(sc.next());
			
			//b1.setFlag1(2);
			System.out.println("Book Type:");
			b1.setBook_type(sc.next());
			System.out.println("Requested by:");
			b1.setRequested_by(sc.next());
			System.out.println("E-mail Id:");
			b1.setE_mail(sc.next());
			String sql = "INSERT INTO requestbook (title,author,publisher,volume,No_copies, request_date,book_type,requested_by,email_id) values "
			   +"('"+b1.getTitle()+"','"
					+b1.getAuthor()+"', '"
					+b1.getPublisher()+"','"
					+b1.getVolume()+"',"
					+b1.getNo_copies()+","
				    + "DATE_FORMAT('"+b1.getRequested_date()+"','%Y-%m-%d'),'"
					+b1.getBook_type()+"','"
					+b1.getRequested_by()+"','"
					+b1.getE_mail()+"')";
			
			int row = st1.executeUpdate(sql);
			if (row > 0) {
				System.out .println("Request forwarded... Once the book is available, you will be notified !!!!");
				
			}
			//conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
			
			ex.printStackTrace();
		} 
		}
		
		public void displayBook(Book book) {
			// TODO Auto-generated method stub
			Book b2 = new Book();
			String query = "SELECT * FROM book";

			// create the java statement
			Statement st;
			try {
				conn = DriverManager.getConnection(url, user, password);
				st = (Statement) conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);
				System.out.format("ISBN\t Title\t Author\t Publisher\t Volume\t Book_type\n");
				
				while (rs.next()) {
				int ISBN = rs.getInt("ISBN");
				b2.setISBN(ISBN);
				String title = rs.getString("title");
				b2.setTitle(title);
				String author = rs.getString("author");
				b2.setAuthor(author);
				String publisher = rs.getString("publisher");
				b2.setPublisher(publisher);
				String volume = rs.getString("volume");
				b2.setVolume(volume);
				String date=rs.getString("purchase_date");
				String book_type = rs.getString("book_type");
				b2.setVolume(book_type);
				System.out.format("%d\t%s\t%s\t%s\t%s\t%s\n",ISBN,title,author,publisher,volume,book_type);
				}
			//	studentsTable.setModel(DbUtils.resultSetToTableModel(result));
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void main(String args[])
		{
			Book_procurement book=new Book_procurement();
			Scanner sc=new Scanner(System.in);
			
			Book b=new Book();
			while(true){
				System.out.println("Choice:1.Add 2.Request 3.Update 4.Delete 5.Display\n");
				int ch=sc.nextInt();
			switch(ch)
			{
			case 1: book.addBook(); break;
	
			case 2: book.requestBook();break;
			case 3: System.out .println("Enter the ISBN of the book to be updated:");
					int new1=sc.nextInt();
					book.updateBook(new1);break;
			case 4: System.out .println("Enter the ISBN of the book to be deleted");
					int del=sc.nextInt();
					book.deleteBook(del);break;
			case 5: System.out .println("***** Currently available books in the Library *****\n");
					book.displayBook(b);break;
			default:System.exit(0);
			}
			}
		}

	
}
