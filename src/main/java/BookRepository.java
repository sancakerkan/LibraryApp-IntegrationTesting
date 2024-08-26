import java.util.ArrayList;
import java.util.List;

public class BookRepository {

	private ArrayList<Book> books = new ArrayList<>();
	private int booksFound = 0;

	public BookRepository() {
		// Initialize the books list with sample data
		books.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));
		books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
		books.add(new Book(715332, "Shrimad Bhagavad Gita", "Krishna Dvaipayana", "Motivational", 20, 18));
		books.add(new Book(935141, "Java: The Complete Reference", "Herbert Schildt", "Educational", 12, 9));
		books.add(new Book(459901, "It", "Stephen King", "Horror", 7, 5));
		books.add(new Book(855141, "Disneyland", "Mickey & Minnie", "Love", 10, 3));
	}

	public Book searchByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}

	public Book searchByISBN(int isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				return book;
			}
		}
		return null;
	}

	public List<Book> searchByGenre(String genre) {
		List<Book> genreBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.getGenre().equalsIgnoreCase(genre)) {
				genreBooks.add(book);
			}
		}
		return genreBooks;
	}

	public int searchISBN(int isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				return 1;
			}
		}
		return 0;
	}

	public boolean getBook(int isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				if ((book.getQuantity() - book.getCheckedOut()) > 0) {
					book.setCheckedOut(book.getCheckedOut() + 1);
					return true;
				}
			}
		}
		return false;
	}

	public boolean submitBook(int isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn && book.getCheckedOut() > 0) {
				book.setCheckedOut(book.getCheckedOut() - 1);
				return true;
			}
		}
		return false;
	}

	public void bookStatus(int isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				System.out.println("\n+> Book details: \n");
				System.out.println("\tTitle: " + book.getTitle() + "\n\tAuthor: " + book.getAuthor() + "\n\tGenre: " + book.getGenre() + "\n\tISBN: " + book.getIsbn() + "\n\tQuantity: " + book.getQuantity() + "\n\tChecked Out: " + String.valueOf(book.getCheckedOut()) + "\n\tAvailable: " + String.valueOf(book.getQuantity() - book.getCheckedOut()));
				break;
			}
		}
	}
}
