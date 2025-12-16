package library;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerV1_5Test {
    LibraryManagerV1_5 libraryManager = new LibraryManagerV1_5();


    @Test
    public void 책_추가() throws Exception {
        //given
        Book newBook = new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326");

        //when
        Long newId = libraryManager.addBook(newBook);

        //then
        assertNotNull(newId);
        assertEquals(newBook.getId(), newId);
    }

    @Test
    public void 데이터_저장() throws Exception {
        //given
        Book book = new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326");
        libraryManager.addBook(book);

        //when
        boolean result = libraryManager.saveDate();

        //then
        assertTrue(result);
    }

    @Test
    public void 데이터_불러오기() throws Exception {
        //given

        //when
        boolean result = libraryManager.loadData();

        //then
        assertTrue(result);
    }

    @Test
    public void Book_List_변환() throws Exception {
        //given
        Book book = new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326");

        //when
        List<String> resultBookList = libraryManager.convertBookToList(book);

        //then
        assertEquals("[null, 9788960980525, 고객의 80%는 비싸도 구매한다, 무라마츠 다츠오, 씨앤톡, 2008, 326, false]", resultBookList.toString());
    }

    @Test
    public void List_Book_변환() throws Exception {
        //given
        Book book = new Book("9788960980525", "고객의 80%는 비싸도 구매한다", "무라마츠 다츠오", "씨앤톡", 2008, "326");
        List<String> bookList = libraryManager.convertBookToList(book);

        //when
        Book resultBook = libraryManager.convertListToBook(bookList);

        //then

    }


}