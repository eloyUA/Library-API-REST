package com.example.library.books.arquitecture.repository;

import com.example.library.books.domain.model.Book;
import com.example.library.books.domain.dto.BookSortEnumDto;
import com.example.library.books.domain.exceptions.BookIdException;
import com.example.library.books.domain.exceptions.BookSearchException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepositoryCollection implements BookRepository {
    private final static Long MAX_ID = 100_000_000_000L;
    private final static Long INIT_NUMBER_BOOKS = 100_000L;
    private final static Map<Long, Book> data = new HashMap<>();

    static {
        Book book1 = new Book(1L, "Titulo 1", "Autor 1", 100, 10.0, true);
        Book book2 = new Book(2L, "Titulo 2", "Autor 2", 200, 20.0, false);
        Book book3 = new Book(3L, "Titulo 3", "Autor 3", 300, 30.0, true);

        data.put(1L, book1);
        data.put(2L, book2);
        data.put(3L, book3);

        /*for (long i = 0; i < INIT_NUMBER_BOOKS; i++) {
            Long id = generateValidId();
            String title = "Book" + i;
            String author = "Author " + i;
            Integer pages = (int) (300.0 * Math.random());
            Double price = 100.0 * Math.random();
            Boolean available = (int) (Math.random() + 0.5) == 0;
            Book book = new Book(id, title, author, pages, price, available);

            data.put(id, book);
        }*/
    }

    @Override
    public Book insert(Book book) {
        Long id = generateValidId();
        book.setId(id);
        data.put(id, new Book(book));
        return book;
    }

    @Override
    public void update(Book book) {
        if (book.getId() == null || !data.containsKey(book.getId())) {
            throw new BookIdException(book.getId());
        }
        data.put(book.getId(), new Book(book));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || !data.containsKey(id)) {
            throw new BookIdException(id);
        }
        data.remove(id);
    }

    @Override
    public List<Book> findByFilters(String author, Boolean available, Double maxPrice) {
        if (author == null && available == null && maxPrice == null) {
            throw new BookSearchException(author, maxPrice, available);
        }

        List<Book> books = new LinkedList<>();
        for (Map.Entry<Long, Book> entry : data.entrySet()) {
            Book currentBook = entry.getValue();
            if ((author == null || currentBook.getAuthor().equals(author)) &&
                    (available == null || currentBook.getAvailable().equals(available)) &&
                    (maxPrice == null || currentBook.getPrice().compareTo(maxPrice) < 0
                            || currentBook.getPrice().equals(maxPrice))) {
                books.add(currentBook);
            }
        }

        return books;
    }

    @Override
    public Book findById(Long id) {
        if (id == null || !data.containsKey(id)) {
            throw new BookIdException(id);
        }
        return new Book(data.get(id));
    }

    @Override
    public List<Book> findAll(BookSortEnumDto sort, Long page, Long limit) {
        if ((page != null && limit == null) || (page == null && limit != null)) {
            throw new IllegalArgumentException("page and limit must be declared.");
        }

        List<Book> books = new ArrayList<>(data.values());
        if (sort != null) {
            books.sort((b1, b2) -> {
                if (BookSortEnumDto.PRICE.equals(sort)) {
                    return (int) (b1.getPrice() - b2.getPrice());
                }
                else if (BookSortEnumDto.TITLE.equals(sort)) {
                    return b1.getTitle().compareTo(b2.getTitle());
                }
                return 0;
            });
        }

        if (page != null && limit != null) {
            if (page < 0) throw new IllegalArgumentException("page must be positive or 0");
            if (limit < 0) throw new IllegalArgumentException("limit must be positive or 0");
            if ((page + 1) * limit > books.size()) throw new IllegalArgumentException("page and limit are out of range");
            return books.subList((int) (page * limit), (int) ((page + 1) * limit));
        }
        return books;
    }

    public static Long generateValidId() {
        long id = (long) (MAX_ID * Math.random());
        while (data.containsKey(id)) {
            id = (long) (MAX_ID * Math.random());
        }
        return id;
    }
}
