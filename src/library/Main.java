package library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        List<Book> bookList = libraryManager.getBookList();
        System.out.println(bookList);

    }
}