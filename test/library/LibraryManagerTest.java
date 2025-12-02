package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {
    private LibraryManager manager;

    @BeforeEach
    void setUp() {
        // 각 테스트 전에 새로운 LibraryManager 인스턴스를 만듬.
        manager = new LibraryManager();

        // 검색 테스트를 위한 기본 데이터 추가
        manager.addBook(new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326")); // ID: 1
        manager.addBook(new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326")); // ID: 2
        manager.addBook(new Book("9791156647508", "IT CookBook, 우분투 리눅스(3판)", "이종원", "씨앤톡", 2022, "4750")); // ID: 3
    }

    // 1. addBook (ID 자동 생성) 테스트
    @Test
    void 책_추가_ID_생성() {
        Book newBook = new Book("isbn", "새로운 책", "저자", "출판사", 2025, "100");
        Long addBookId = manager.addBook(newBook);

        assertNotNull(addBookId);
    }

    @Test
    public void 책_추가_확인() throws Exception {
        //given
        Book newBook = new Book("isbn", "새로운 책", "저자", "출판사", 2025, "100");

        //when
        manager.addBook(newBook);

        //then
        assertTrue(manager.getBookList().contains(newBook));
    }
}