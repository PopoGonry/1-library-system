import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Book> bookList;

    // 임시리스트
    public LibraryManager() {
        bookList = new ArrayList<>();
    }

    // 임시 addBook
    public Long addBook(Book book) {
        book.setId((long) (bookList.size() + 1));
        bookList.add(book);
        return book.getId();
    }

    // 제목 검색
    public List<Book> searchBookByName(String name) {
        List<Book> result = new ArrayList<>();

        for (Book book : bookList) {
            String title = book.getTitle().toLowerCase();
            String keyword = name.toLowerCase();

            if (title.contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    // 저자 검색
    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();

        for (Book book : bookList) {
            String bookAuthor = book.getAuthor().toLowerCase();
            String keyword = author.toLowerCase();

            if (bookAuthor.contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    // 분류 코드 검색
    public List<Book> searchBookByClassificationCode(String classificationCode) {
        List<Book> result = new ArrayList<>();

        for (Book book : bookList) {
            String bookCode = book.getClassificationCode();

            if (bookCode.startsWith(classificationCode)) {
                result.add(book);
            }
        }
        return result;
    }
    // 임시 list
    public List<Book> getBookList() {
        return bookList;
    }
}
