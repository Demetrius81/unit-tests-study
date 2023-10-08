package book;

import org.example.homeWork.book.Book;
import org.example.homeWork.book.BookRepository;
import org.example.homeWork.book.BookService;
import org.example.homeWork.book.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

//Tests with Mock
@ExtendWith(MockitoExtension.class)
@DisplayName("BookService Mock Tests")
class BookServiceMockitoTests {
    @Mock
    BookRepository databaseMock;


    @Test
    @DisplayName("findBookById Mock Test")
    void findBookByIdCheckClassWithMockTest() {
        assertNotNull(databaseMock, "Mock object is null");
        when(databaseMock.findById("0")).thenReturn(new Book("0"));
        BookService bookService = new BookService(databaseMock);
        Book mockBook = bookService.findBookById("0");
        assertInstanceOf(Book.class, mockBook, "Method return not Book class");
    }

    @Test
    @DisplayName("findAll Mock Test")
    void findAllBooksCheckClassWithMockTest() {
        assertNotNull(databaseMock, "Mock object is null");
        when(databaseMock.findAll()).thenReturn(new ArrayList<>());
        BookService bookService = new BookService(databaseMock);
        List<Book> mockList = bookService.findAllBooks();
        assertInstanceOf(ArrayList.class, mockList, "Method return not ArrayList");
    }

}

//Tests with Fake
@DisplayName("BookService Fake Tests")
class BookServiceFakeTests {

    private static BookRepository fakeRepository;

    @BeforeAll
    static void setUp(){
        fakeRepository = new InMemoryBookRepository();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("findBookById Fake Test")
    void findBookByIdWithFakeTest(String id) {
        Book expectedBook = fakeRepository.findById(id);
        BookService service = new BookService(fakeRepository);
        assertNotNull(service, "BookService object is null");
        Book actualBook = service.findBookById(id);
        assertNotNull(actualBook, "findBookById(id) returns null");
        assertEquals(expectedBook, actualBook, "findBookById(id) returns not expected Book");
    }

    @Test
    @DisplayName("findAll Fake Test")
    void findAllBooksWithFakeTest() {
        List<Book> expectedBooks = fakeRepository.findAll();
        BookService service = new BookService(fakeRepository);
        assertNotNull(service, "BookService object is null");
        List<Book> actualBooks = service.findAllBooks();
        assertNotNull(actualBooks, "findAllBooks() returns null");
        assertIterableEquals(expectedBooks, actualBooks, "findAllBooks() returns not expected List");
    }
}