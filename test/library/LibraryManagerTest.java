package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {

    private LibraryManager manager;

    @BeforeEach
    void setUp() {
        manager = new LibraryManager();

        manager.addBook(new Book(1L,"9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오",
                "씨앤톡", 2008, "326",false));

    }

    @Test
    void 제목_정확검색() {
        List<Book> result = manager.searchBookByName("고객의 80%는 비싸도 구매한다");
        assertEquals(1, result.size());
    }

    @Test
    void 제목_부분검색() {
        List<Book> result = manager.searchBookByName("고객");
        assertEquals(1, result.size());
    }

    @Test
    void 제목_검색실패() {
        List<Book> result = manager.searchBookByName("100%");
        assertTrue(result.isEmpty());
    }


    @Test
    void 저자_정확검색() {
        List<Book> result = manager.searchBookByAuthor("무라마츠 다츠오");
        assertEquals(1, result.size());
    }

    @Test
    void 저자_부분검색() {
        List<Book> result = manager.searchBookByAuthor("마츠");
        assertEquals(1, result.size());
    }

    @Test
    void 저자_검색실패() {
        List<Book> result = manager.searchBookByAuthor("가나다");
        assertTrue(result.isEmpty());
    }



    @Test
    void 분류코드_정확검색() {
        List<Book> result = manager.searchBookByClassificationCode("326");
        assertEquals(1, result.size());
    }

    @Test
    void 분류코드_접두어검색() {
        List<Book> result = manager.searchBookByClassificationCode("3");
        assertEquals(1, result.size());
    }

    @Test
    void 분류코드_검색실패() {
        List<Book> result = manager.searchBookByClassificationCode("400");
        assertTrue(result.isEmpty());
    }
}
