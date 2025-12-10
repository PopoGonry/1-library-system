package library;

import java.io.*;
import java.util.*;

public class LibraryManagerV1_5 extends LibraryManager {

    private static final String FILE_NAME = "library.json";

    private HashMap<Long, Book> bookHashMap = new HashMap<>();

    @Override
    public Long addBook(Book book) {
        long newId;

        if (bookHashMap.isEmpty()) {
            newId = 1L;
        } else {
            Long maxId = 0L;
            for (Book existingBook : bookHashMap.values()) {
                if (existingBook.getId() != null) {
                    if (existingBook.getId() > maxId) {
                        maxId = existingBook.getId();
                    }
                }
            }

            newId = maxId + 1;
        }

        book.setId(newId);

        bookHashMap.put(book.getId(), book);

        return book.getId();
    }

    public boolean saveDate() {
        // try-with-resources 구문 (파일을 열고 자동으로 닫아줌)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Map.Entry<Long, Book> bookEntry : bookHashMap.entrySet()) {
                Long key = bookEntry.getKey();
                Book book = bookEntry.getValue();

                String line = key + "," + String.join(",", convertBookToList(book));

                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일 저장 완료: " + FILE_NAME);

            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {

                // 콤마(,)를 기준으로 문자열 자르기
                List<String> list = Arrays.stream(line.split(",")).toList();

                // CSV가 깨졌거나 빈 줄일 경우 대비
                if (list.size() < 8) continue;

                Book book = convertListToBook(list);

                bookHashMap.put(book.getId(), book);
            }
            System.out.println("파일 로드 완료!");

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> convertBookToList(Book book) {
        List<String> listBook =  new ArrayList<>();
        listBook.set(0, String.valueOf(book.getId()));
        listBook.set(1, book.getIsbn());
        listBook.set(2, book.getTitle());
        listBook.set(3, book.getAuthor());
        listBook.set(4, book.getPublisher());
        listBook.set(5, String.valueOf(book.getPublicationYear()));
        listBook.set(6, book.getClassificationCode());
        listBook.set(7, String.valueOf(book.isLoaned()));
        return listBook;
    }

    Book convertListToBook(List<String> list) {
        if (list.size() < 8) {
            throw new IllegalArgumentException();
        }

        return new Book(Long.parseLong(list.get(0)),
                list.get(1),
                list.get(2),
                list.get(3),
                list.get(4),
                Integer.parseInt(list.get(5)),
                list.get(6),
                Boolean.parseBoolean(list.get(7)));
    }


    public HashMap<Long, Book> getBookHashMap() {
        return bookHashMap;
    }
}
