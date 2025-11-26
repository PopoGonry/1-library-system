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

    /**
     * 박우현
     */
//    public List<Book> searchBookByName(String name) {}
//    public List<Book> searchBookByAuthor(String name) {}
//    public List<Book> searchBookByClassificationCode(String name) {}

    /**
     * 김규민
     */

//    public boolean loanBook(Long bookId) {}


    public List<Book> getBookList() {
        return bookList;
    }
}
