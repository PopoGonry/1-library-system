package library;

import java.io.*;
import java.util.*;

public class LibraryManagerV1_5 extends LibraryManager {

    private static final String FILE_NAME = "library.csv";

    private final HashMap<Long, Book> bookHashMap = new HashMap<>();

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

        super.getBookList().add(book);
        bookHashMap.put(book.getId(), book);

        return book.getId();
    }


    public boolean saveDate() {
        // try-with-resources 구문 (파일을 열고 자동으로 닫아줌)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Map.Entry<Long, Book> bookEntry : bookHashMap.entrySet()) {
                Long key = bookEntry.getKey();
                Book book = bookEntry.getValue();

                String line = String.join(",", convertBookToList(book));

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
        // 1. 파일 객체 생성
        File file = new File(FILE_NAME);

        // 2. 파일이 존재하는지 확인하고 없으면 생성
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("데이터 파일이 없어 새로 생성했습니다: " + FILE_NAME);
                return true; // 빈 파일이므로 읽을 것이 없어 바로 종료 (성공 처리)
            } catch (IOException e) {
                System.out.println("파일 생성 중 오류 발생");
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            bookHashMap.clear();
            while ((line = br.readLine()) != null) {

                // 콤마(,)를 기준으로 문자열 자르기
                List<String> list = Arrays.stream(line.split(",")).toList();

                // CSV가 깨졌거나 빈 줄일 경우 대비
                if (list.size() < 8) continue;

                Book book = convertListToBook(list);

                bookHashMap.put(book.getId(), book);
                super.getBookList().add(book);
            }
            System.out.println("파일 로드 완료!");

            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<String> convertBookToList(Book book) {
        List<String> listBook =  new ArrayList<>();
        listBook.add(String.valueOf(book.getId()));
        listBook.add(book.getIsbn());
        listBook.add(book.getTitle());
        listBook.add(book.getAuthor());
        listBook.add(book.getPublisher());
        listBook.add(String.valueOf(book.getPublicationYear()));
        listBook.add(book.getClassificationCode());
        listBook.add(String.valueOf(book.isLoaned()));
        return listBook;
    }

    Book convertListToBook(List<String> list) {
        if (list.size() < 8) {
            throw new IllegalArgumentException();
        }

        return new Book(
                list.get(0).equals("null") ? null : Long.parseLong(list.get(0)),
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
