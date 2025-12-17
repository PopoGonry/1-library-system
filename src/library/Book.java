package library;

import java.util.Objects;

public class Book {
    private Long id; // 개별 재고 항목 ID
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classificationCode;
    private boolean isLoaned;

    // 생성자
    public Book(String isbn, String title, String author, String publisher, int publicationYear, String classificationCode) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.classificationCode = classificationCode;
        this.isLoaned = false;
    }

    public Book() {
    }

    public Book(Long id, String isbn, String title, String author, String publisher, int publicationYear, String classificationCode, boolean isLoaned) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.classificationCode = classificationCode;
        this.isLoaned = isLoaned;
    }

    // Getter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", classificationCode='" + classificationCode + '\'' +
                ", isLoaned=" + isLoaned +
                '}';
    }

    public String toStringWithFormat() {
        return "[ " + title + " ]" +
                "\nisbn: " + isbn +
                "\n저자: " + author +
                "\n출판사: " + publisher +
                "\n출판연도: " + publicationYear +
                "\n분류코드: " + classificationCode +
                "\n대출가능여부: " + (isLoaned ? "불가능" : "가능")
                ;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && isLoaned == book.isLoaned && Objects.equals(id, book.id) && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher) && Objects.equals(classificationCode, book.classificationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, publisher, publicationYear, classificationCode, isLoaned);
    }
}