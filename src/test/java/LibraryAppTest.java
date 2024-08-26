import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryAppTest {

    @Test
    void testSearchByTitle() {
        // Mocking the BookRepository
        BookRepository mockRepo = Mockito.mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for searchByTitle
        Book mockBook = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        when(mockRepo.searchByTitle("Pride and Prejudice C")).thenReturn(mockBook);
        when(mockRepo.searchByTitle("NotExist")).thenReturn(null);

        // Test for existing title
        Book foundBook = libraryApp.findByTitle("Pride and Prejudice C");
        assertNotNull(foundBook);
        assertEquals("Pride and Prejudice C", foundBook.getTitle());

        // Test for non-existing title
        foundBook = libraryApp.findByTitle("NotExist");
        assertNull(foundBook);
    }

    @Test
    void testWithdrawBook() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for getBook
        when(mockRepo.getBook(253910)).thenReturn(true);
        when(mockRepo.getBook(123456)).thenReturn(false);

        // Test for successful withdrawal
        boolean success = libraryApp.withdrawBook(253910);
        assertTrue(success);

        // Test for unsuccessful withdrawal (book not found)
        success = libraryApp.withdrawBook(123456);
        assertFalse(success);
    }

    @Test
    void testSubmitBook() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for submitBook
        when(mockRepo.submitBook(253910)).thenReturn(true);
        when(mockRepo.submitBook(123456)).thenReturn(false);

        // Test for successful submission
        boolean success = libraryApp.depositBook(253910);
        assertTrue(success);

        // Test for unsuccessful submission (book not found)
        success = libraryApp.depositBook(123456);
        assertFalse(success);
    }

    @Test
    void testSearchByISBN() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for searchByISBN
        Book mockBook = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        when(mockRepo.searchByISBN(253910)).thenReturn(mockBook);
        when(mockRepo.searchByISBN(123456)).thenReturn(null);

        // Test for existing ISBN
        Book foundBook = libraryApp.findByISBN(253910);
        assertNotNull(foundBook);
        assertEquals(253910, foundBook.getIsbn());

        // Test for non-existing ISBN
        foundBook = libraryApp.findByISBN(123456);
        assertNull(foundBook);
    }

    @Test
    void testSearchByGenre() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for searchByGenre
        List<Book> loveBooks = new ArrayList<>();
        loveBooks.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));
        loveBooks.add(new Book(855141, "Disneyland", "Mickey & Minnie", "Love", 10, 3));
        when(mockRepo.searchByGenre("Love")).thenReturn(loveBooks);
        when(mockRepo.searchByGenre("UnknownGenre")).thenReturn(new ArrayList<>());

        // Test for existing genre
        boolean found = libraryApp.findByGenre("Love");
        assertTrue(found);

        // Test for non-existing genre
        found = libraryApp.findByGenre("UnknownGenre");
        assertFalse(found);
    }

}
