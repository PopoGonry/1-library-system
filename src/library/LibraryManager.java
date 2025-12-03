package library;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private final List<Book> bookList;

    public LibraryManager() {
        this.bookList = new ArrayList<>();
    }

    public Long addBook(Book book) {
        long newId;

        if (bookList.isEmpty()) {
            newId = 1L;
        } else {
            Long maxId = 0L;
            for (Book existingBook : bookList) {
                if (existingBook.getId() != null) {
                    if (existingBook.getId() > maxId) {
                        maxId = existingBook.getId();
                    }
                }
            }

            newId = maxId + 1;
        }

        book.setId(newId);

        bookList.add(book);

        return book.getId();
    }

    public Book getBookById(long bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /**
     * 박우현
     */
//    public List<Book> searchBookByName(String name) {}
//    public List<Book> searchBookByAuthor(String name) {}
//    public List<Book> searchBookByClassificationCode(String name) {}

    /**
     * 김규민
     */

    public boolean loanBook(Long bookId) {
        Book bookToLoan = null;

        for (Book book : bookList) {
            if (book.getId().equals(bookId)) {
                bookToLoan = book;
                break;
            }
        }

        if (bookToLoan == null) {
            System.out.println("[대출 실패] ID " + bookId + "에 해당하는 도서를 찾을 수 없습니다.");
            return false;
        }


        if (!bookToLoan.isLoaned()) {
            bookToLoan.setLoaned(true);

            System.out.println("[대출 성공] 도서 ID: " + bookId + ", 제목: '" + bookToLoan.getTitle() + "'");
            return true;
        } else {
            System.out.println("[대출 실패] 도서 ID " + bookId + ", 제목: '" + bookToLoan.getTitle() + "'은(는) 이미 대출 중입니다.");

            return false;
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
