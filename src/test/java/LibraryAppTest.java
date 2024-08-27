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
        Book mockBook1 = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        Book mockBook2 = new Book(654321, "War and Peace", "Leo Tolstoy", "Historical", 12, 9);
        when(mockRepo.searchByTitle("Pride and Prejudice C")).thenReturn(mockBook1);
        when(mockRepo.searchByTitle("War and Peace")).thenReturn(mockBook2);
        when(mockRepo.searchByTitle("NotExist")).thenReturn(null);

        // Test for existing title 1
        Book foundBook = libraryApp.findByTitle("Pride and Prejudice C");
        assertNotNull(foundBook);
        assertEquals("Pride and Prejudice C", foundBook.getTitle());

        // Test for existing title 2
        foundBook = libraryApp.findByTitle("War and Peace");
        assertNotNull(foundBook);
        assertEquals("War and Peace", foundBook.getTitle());

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
        when(mockRepo.getBook(789101)).thenReturn(true);

        // Test for successful withdrawal
        boolean success = libraryApp.withdrawBook(253910);
        assertTrue(success);

        // Test for unsuccessful withdrawal (book not found)
        success = libraryApp.withdrawBook(123456);
        assertFalse(success);

        // Test for another successful withdrawal
        success = libraryApp.withdrawBook(789101);
        assertTrue(success);
    }

    @Test
    void testSubmitBook() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for submitBook
        when(mockRepo.submitBook(253910)).thenReturn(true);
        when(mockRepo.submitBook(123456)).thenReturn(false);
        when(mockRepo.submitBook(789101)).thenReturn(true);

        // Test for successful submission
        boolean success = libraryApp.depositBook(253910);
        assertTrue(success);

        // Test for unsuccessful submission (book not found)
        success = libraryApp.depositBook(123456);
        assertFalse(success);

        // Test for another successful submission
        success = libraryApp.depositBook(789101);
        assertTrue(success);
    }

    @Test
    void testSearchByISBN() {
        // Mocking the BookRepository
        BookRepository mockRepo = mock(BookRepository.class);
        LibraryApp libraryApp = new LibraryApp(mockRepo);

        // Defining behavior for searchByISBN
        Book mockBook1 = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        Book mockBook2 = new Book(654321, "War and Peace", "Leo Tolstoy", "Historical", 12, 9);
        when(mockRepo.searchByISBN(253910)).thenReturn(mockBook1);
        when(mockRepo.searchByISBN(654321)).thenReturn(mockBook2);
        when(mockRepo.searchByISBN(123456)).thenReturn(null);

        // Test for existing ISBN 1
        Book foundBook = libraryApp.findByISBN(253910);
        assertNotNull(foundBook);
        assertEquals(253910, foundBook.getIsbn());

        // Test for existing ISBN 2
        foundBook = libraryApp.findByISBN(654321);
        assertNotNull(foundBook);
        assertEquals(654321, foundBook.getIsbn());

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

        List<Book> historicalBooks = new ArrayList<>();
        historicalBooks.add(new Book(654321, "War and Peace", "Leo Tolstoy", "Historical", 12, 9));

        when(mockRepo.searchByGenre("Love")).thenReturn(loveBooks);
        when(mockRepo.searchByGenre("Historical")).thenReturn(historicalBooks);
        when(mockRepo.searchByGenre("UnknownGenre")).thenReturn(new ArrayList<>());

        // Test for existing genre 1
        boolean found = libraryApp.findByGenre("Love");
        assertTrue(found);

        // Test for existing genre 2
        found = libraryApp.findByGenre("Historical");
        assertTrue(found);

        // Test for non-existing genre
        found = libraryApp.findByGenre("UnknownGenre");
        assertFalse(found);
    }

}
