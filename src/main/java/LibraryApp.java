import java.util.List;

public class LibraryApp {

	private BookRepository repo;

	// Default constructor for regular use
	public LibraryApp() {
		this.repo = new BookRepository();
	}

	// Constructor for injecting a mocked BookRepository (used in testing)
	public LibraryApp(BookRepository repo) {
		this.repo = repo;
	}

	// Method to find a book by its title
	public Book findByTitle(String title) {
		// Assuming BookRepository's searchByTitle now returns a Book object
		return repo.searchByTitle(title);
	}

	// Method to find a book by its ISBN number
	public Book findByISBN(int isbn) {
		// Assuming BookRepository's searchByISBN now returns a Book object
		return repo.searchByISBN(isbn);
	}

	// Method to find books by genre
	public boolean findByGenre(String genre) {
		// Assuming BookRepository's searchByGenre now returns a list of books
		List<Book> books = repo.searchByGenre(genre);
		return !books.isEmpty();
	}

	// Method to find the ISBN
	public int findISBN(int isbn) {
		return repo.searchISBN(isbn);
	}

	// Method to withdraw a book
	public boolean withdrawBook(int isbn) {
		return repo.getBook(isbn);
	}

	// Method to deposit (submit) a book
	public boolean depositBook(int isbn) {
		return repo.submitBook(isbn);
	}

	// Method to get the status of a book
	public void getStatus(int isbn) {
		repo.bookStatus(isbn);
	}
}
