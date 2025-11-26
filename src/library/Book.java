package library;

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
}