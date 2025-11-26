import java.util.List;
import java.util.Optional;

public class LibraryManager {

    private List<Book> bookList;

    public boolean loanBook(Long bookId) {
        Book bookToLoan;

        for (Book book : bookList) {
            if (book.getId == bookId) {
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

}