package library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        System.out.println("1. 입력");
        System.out.println("2. 검색");
        System.out.println("3. 대출");
        System.out.println("4. 출력");
        System.out.println("메뉴를 선택하세요. : ");
        int select = sc.nextInt();

        switch(select) {
            case 1:
                System.out.println("책의 정보(isbn, 제목, 저자, 출판사, 출판 연도, 분류 코드)를 입력해주세요. :");
                System.out.println("isbn : ");
                String isbn = sc.next();
                System.out.println("제목 : ");
                String title = sc.next();
                System.out.println("저자 : ");
                String author = sc.next();
                System.out.println("출판사 : ");
                String publisher = sc.next();
                System.out.println("제목 : ");
                int publicationYear = sc.nextInt();
                System.out.println("분류 코드 : ");
                String classificationCode = sc.next();

                Book book = libraryManager.getBookById(libraryManager.addBook(new Book(isbn, title, author, publisher, publicationYear, classificationCode)));

                System.out.println(book);
                System.out.println("\n책 등록이 정상적으로 처리되었습니다.");

                break;

            case 2:

//                System.out.println("1. 제목을 통해 검색");
//                System.out.println("2. 저자를 통해 검색");
//                System.out.println("3. 분류 코드를 통해 검색");
//                System.out.println("검색 방법을 선택하세요: ");
//                int searchSelect = sc.nextInt();
//                if (!(1 <= searchSelect && searchSelect <= 3)) {
//                    System.out.println("잘못된 입력.");
//                    return;
//                }
//
//                List<Book> result;
//                String keyword;
//                switch (searchSelect) {
//                    case 1:
//                        System.out.println("제목을 입력해주세요. :");
//                        keyword = sc.next();
//
//                       result = libraryManager.searchBookByName(keyword);
//
//                    case 2:
//                        System.out.println("저자를 입력해주세요. :");
//                        keyword = sc.next();
//                        result = libraryManager.searchBookByAuthor(keyword);
//
//                    case 3:
//                        System.out.println("분류 코드를 입력해주세요. :");
//                        keyword = sc.next();
//                        result = libraryManager.searchBookByClassificationCode(keyword);
//
//                    default:
//                        for (Book searchBook : result) {
//                            System.out.println(searchBook);
//                        }
//                        System.out.println("책 검색이 정상적으로 처리되었습니다.");
//                        break;
//                }

            case 3:
                System.out.println("책의 id를 입력해주세요. : ");
                int bookId = sc.nextInt();
                boolean isSuccessLoan = libraryManager.loanBook((long) bookId);

                System.out.println(libraryManager.getBookById(bookId));

                System.out.println();

                if(isSuccessLoan) {
                    System.out.println("책 대출이 정상적으로 처리되었습니다.");
                }
                else {
                    System.out.println("책이 이미 대출 중 입니다.");
                }

            case 4:
                List<Book> bookList = libraryManager.getBookList();
                for (Book resultBook : bookList) {
                    System.out.println(resultBook);
                }
        }
    }
}